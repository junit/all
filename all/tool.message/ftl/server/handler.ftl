package com.mokylin.game.server.logic.${pkg}.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.${pkg}.message.${name}Message;

public class ${name}Handler extends Handler{
	private static Logger logger = Logger.getLogger(${name}Handler.class);
    @Override
    public void exec() {
    	try {
    		${name}Message msg = (${name}Message)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
