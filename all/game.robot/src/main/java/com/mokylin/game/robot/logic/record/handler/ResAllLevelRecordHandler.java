package com.mokylin.game.robot.logic.record.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.record.message.ResAllLevelRecordMessage;

public class ResAllLevelRecordHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAllLevelRecordHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAllLevelRecordMessage msg = (ResAllLevelRecordMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
