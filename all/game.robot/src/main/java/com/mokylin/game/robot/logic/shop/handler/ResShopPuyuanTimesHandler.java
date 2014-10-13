package com.mokylin.game.robot.logic.shop.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.shop.message.ResShopPuyuanTimesMessage;

public class ResShopPuyuanTimesHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResShopPuyuanTimesHandler.class);
    @Override
    public void exec() {
    	try {
    		ResShopPuyuanTimesMessage msg = (ResShopPuyuanTimesMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
