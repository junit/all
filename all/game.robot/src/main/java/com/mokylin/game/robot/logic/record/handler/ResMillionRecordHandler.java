package com.mokylin.game.robot.logic.record.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.record.message.ResMillionRecordMessage;

public class ResMillionRecordHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResMillionRecordHandler.class);
    @Override
    public void exec() {
    	try {
    		ResMillionRecordMessage msg = (ResMillionRecordMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
