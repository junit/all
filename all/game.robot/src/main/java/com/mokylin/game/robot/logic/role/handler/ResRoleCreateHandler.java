package com.mokylin.game.robot.logic.role.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.role.message.ResRoleCreateMessage;

public class ResRoleCreateHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResRoleCreateHandler.class);
    @Override
    public void exec() {
    	try {
    		ResRoleCreateMessage msg = (ResRoleCreateMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
