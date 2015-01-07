package com.mokylin.game.server.logic.shop.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.shop.message.ReqShopBuyMessage;

public class ReqShopBuyHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqShopBuyHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqShopBuyMessage msg = (ReqShopBuyMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
