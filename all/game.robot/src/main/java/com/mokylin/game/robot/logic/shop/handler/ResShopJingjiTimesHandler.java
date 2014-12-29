package com.mokylin.game.robot.logic.shop.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.shop.message.ResShopJingjiTimesMessage;

public class ResShopJingjiTimesHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResShopJingjiTimesHandler.class);
    @Override
    public void exec() {
    	try {
    		ResShopJingjiTimesMessage msg = (ResShopJingjiTimesMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
