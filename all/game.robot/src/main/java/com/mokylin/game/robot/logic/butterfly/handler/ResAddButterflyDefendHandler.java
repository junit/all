package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResAddButterflyDefendMessage;

public class ResAddButterflyDefendHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAddButterflyDefendHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAddButterflyDefendMessage msg = (ResAddButterflyDefendMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
