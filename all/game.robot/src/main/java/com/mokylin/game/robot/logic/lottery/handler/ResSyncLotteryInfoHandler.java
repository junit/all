package com.mokylin.game.robot.logic.lottery.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.lottery.message.ResSyncLotteryInfoMessage;

public class ResSyncLotteryInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSyncLotteryInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSyncLotteryInfoMessage msg = (ResSyncLotteryInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
