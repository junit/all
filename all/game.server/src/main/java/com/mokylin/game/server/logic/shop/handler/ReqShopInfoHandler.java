package com.mokylin.game.server.logic.shop.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.shop.message.ReqShopInfoMessage;

public class ReqShopInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqShopInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqShopInfoMessage msg = (ReqShopInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
