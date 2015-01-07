package com.mokylin.game.server.logic.lottery.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.lottery.message.ReqStartLotteryMessage;

public class ReqStartLotteryHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqStartLotteryHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqStartLotteryMessage msg = (ReqStartLotteryMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
