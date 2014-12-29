package com.mokylin.game.robot.logic.character.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.character.message.ResCharacterStageUpMessage;

public class ResCharacterStageUpHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResCharacterStageUpHandler.class);
    @Override
    public void exec() {
    	try {
    		ResCharacterStageUpMessage msg = (ResCharacterStageUpMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
