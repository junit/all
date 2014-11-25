package com.mokylin.game.server.logic.account.handler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.account.message.ReqAccountTestMessage;
import com.mokylin.game.server.logic.account.message.ResAccountTestMessage;

public class ReqAccountTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqAccountTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqAccountTestMessage msg = (ReqAccountTestMessage)this.getMessage();
    		ResAccountTestMessage ret = new ResAccountTestMessage();
    		ret.setStr(msg.getStr());
    		ret.setTime(msg.getTime());
    		ManagerPool.context.write((Account)this.getExcutor(), ret);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
