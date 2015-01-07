package com.mokylin.game.server.logic.shop.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.shop.message.ReqShopRefreshMessage;

public class ReqShopRefreshHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqShopRefreshHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqShopRefreshMessage msg = (ReqShopRefreshMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
