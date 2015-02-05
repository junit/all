package com.mokylin.game.server.logic.login.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.server.logic.login.message.ReqLoginTestMessage;
import com.mokylin.game.server.logic.login.message.ResLoginTestMessage;

public class ReqLoginTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqLoginTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqLoginTestMessage msg = (ReqLoginTestMessage)this.getMessage();
    		ResLoginTestMessage ret = new ResLoginTestMessage();
    		ret.setStr(msg.getStr());
    		ret.setTime(msg.getTime());
    		getContext().writeAndFlush(ret);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
