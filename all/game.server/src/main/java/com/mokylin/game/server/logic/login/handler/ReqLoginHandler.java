package com.mokylin.game.server.logic.login.handler;

import com.mokylin.game.core.cache.ICallBack;
import com.mokylin.game.core.message.bean.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.account.AccountKey;
import com.mokylin.game.server.logic.login.message.ReqLoginMessage;
import com.mokylin.game.server.manager.ManagerPool;

public class ReqLoginHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqLoginHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqLoginMessage msg = (ReqLoginMessage)this.getMessage();
    		ManagerPool.account.getCache().get(new AccountKey(msg.getName(), msg.getServerId()), new ICallBack<Account>() {
				
				@Override
				public void exec(Account v) {
					logger.error("获取到:" + v);
				}
			});
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
