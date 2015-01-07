package com.mokylin.game.server.logic.signin.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.signin.message.ReqSigninMessage;

public class ReqSigninHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqSigninHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqSigninMessage msg = (ReqSigninMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
