package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.login.message.ResCreatePlayerMessage;

public class ResCreatePlayerHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResCreatePlayerHandler.class);
    @Override
    public void exec() {
    	try {
    		ResCreatePlayerMessage msg = (ResCreatePlayerMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
