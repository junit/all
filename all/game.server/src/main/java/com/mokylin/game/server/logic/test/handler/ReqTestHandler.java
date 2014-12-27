package com.mokylin.game.server.logic.test.handler;

import com.mokylin.game.core.message.bean.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.server.logic.test.message.ReqTestMessage;
import com.mokylin.game.server.logic.test.message.ResTestMessage;

public class ReqTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqTestMessage msg = (ReqTestMessage)this.getMessage();
    		ResTestMessage ret = new ResTestMessage();
    		ret.setTime(msg.getTime());
    		this.getContext().writeAndFlush(ret);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
