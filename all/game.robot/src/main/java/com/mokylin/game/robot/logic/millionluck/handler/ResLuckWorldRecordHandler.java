package com.mokylin.game.robot.logic.millionluck.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.millionluck.message.ResLuckWorldRecordMessage;

public class ResLuckWorldRecordHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLuckWorldRecordHandler.class);
    @Override
    public void exec() {
    	try {
    		ResLuckWorldRecordMessage msg = (ResLuckWorldRecordMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
