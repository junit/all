package com.mokylin.game.server.logic.login.handler;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.context.ContextAttribute;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.login.RetCode;
import com.mokylin.game.server.logic.login.message.ReqLoginMessage;
import com.mokylin.game.server.logic.login.message.ResLoginFailedMessage;

public class ReqLoginHandler extends Handler {
	private static Logger logger = Logger.getLogger(ReqLoginHandler.class);

	@Override
    public void exec() {
    	try {
    		Long accountId = null;
    		synchronized (this.getContext()) { // 改变和获取的时候,加锁
    			accountId = this.getContext().attr(ContextAttribute.ACCOUNT_ID).get();
    		}
    		if (accountId != null) {
    			sendError(getContext(), RetCode.LOGINED);
    			return ;
    		}
    		
    		ReqLoginMessage msg = (ReqLoginMessage)this.getMessage();
    		
    		if (ManagerPool.config.getConfigs().containsKey(msg.getServer())) { // server 判定
    			sendError(getContext(), RetCode.SERVER_ERROR);
    			return ;
    		}
    		
    		// TODO platform
    		Account account = ManagerPool.account.get(msg.getAccountName(), null, msg.getServer());
    		if (account == null) {
    			account = ManagerPool.account.create(msg.getAccountName(), null, msg.getServer()); // TODO platform
    		}
    		
    		if (account == null) {
    			sendError(getContext(), RetCode.CRATE_ERROR);
    			return ;
    		}
    		
    		if (!ManagerPool.account.checkKey(account, msg.getCheck())) {
    			sendError(getContext(), RetCode.KEY_ERROR);
    			return ;
    		}
    		
    		onLoginSuc(this.getContext(), account);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }

	private void onLoginSuc(ChannelHandlerContext context, Account account) {
		ChannelHandlerContext oldContext = ManagerPool.context.getContexts().get(account.getId());
		if (oldContext != null) {
			ContextUtil.close(oldContext, "顶号");
		}
		ManagerPool.context.getContexts().put(account.getId(), context);
		
		// TODO 告知前端登录成功
	}

	private void sendError(ChannelHandlerContext ctx, RetCode code) {
		ResLoginFailedMessage msg = new ResLoginFailedMessage();
		msg.setErr(code.getValue());
		ManagerPool.context.write(ctx, msg);
	}
}
