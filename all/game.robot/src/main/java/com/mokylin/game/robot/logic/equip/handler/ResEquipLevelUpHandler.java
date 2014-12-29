package com.mokylin.game.robot.logic.equip.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.equip.message.ResEquipLevelUpMessage;

public class ResEquipLevelUpHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEquipLevelUpHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEquipLevelUpMessage msg = (ResEquipLevelUpMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
