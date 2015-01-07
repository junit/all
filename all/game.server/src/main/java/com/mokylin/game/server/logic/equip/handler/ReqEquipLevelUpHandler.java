package com.mokylin.game.server.logic.equip.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.equip.message.ReqEquipLevelUpMessage;

public class ReqEquipLevelUpHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEquipLevelUpHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEquipLevelUpMessage msg = (ReqEquipLevelUpMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
