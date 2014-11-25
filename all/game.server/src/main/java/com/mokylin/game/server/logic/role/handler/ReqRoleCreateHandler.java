package com.mokylin.game.server.logic.role.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.role.message.ReqRoleCreateMessage;

public class ReqRoleCreateHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqRoleCreateHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqRoleCreateMessage msg = (ReqRoleCreateMessage)this.getMessage();
    		ManagerPool.role.create((Account)this.getExcutor(), msg);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
