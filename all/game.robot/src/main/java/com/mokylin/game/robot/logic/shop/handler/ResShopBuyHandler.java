package com.mokylin.game.robot.logic.shop.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.shop.message.ResShopBuyMessage;

public class ResShopBuyHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResShopBuyHandler.class);
    @Override
    public void exec() {
    	try {
    		ResShopBuyMessage msg = (ResShopBuyMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
