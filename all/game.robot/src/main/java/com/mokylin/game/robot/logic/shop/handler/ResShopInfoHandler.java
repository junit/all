package com.mokylin.game.robot.logic.shop.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.shop.message.ResShopInfoMessage;

public class ResShopInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResShopInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResShopInfoMessage msg = (ResShopInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
