package com.mokylin.game.robot.logic.record.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.record.message.ResSingleLevelRecordMessage;

public class ResSingleLevelRecordHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSingleLevelRecordHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSingleLevelRecordMessage msg = (ResSingleLevelRecordMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
