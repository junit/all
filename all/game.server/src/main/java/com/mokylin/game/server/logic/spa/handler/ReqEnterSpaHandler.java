package com.mokylin.game.server.logic.spa.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.spa.message.ReqEnterSpaMessage;

public class ReqEnterSpaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEnterSpaHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEnterSpaMessage msg = (ReqEnterSpaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
