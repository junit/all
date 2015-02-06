package com.mokylin.game.server.logic.map.handler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.map.message.ReqMapEnterMessage;
import com.mokylin.game.server.logic.role.Role;

public class ReqMapEnterHandler extends Handler {
	private static Logger logger = Logger.getLogger(ReqMapEnterHandler.class);

	@Override
	public void exec() {
		try {
			ReqMapEnterMessage msg = (ReqMapEnterMessage) this.getMessage();

			Account account = (Account) this.getExcutor();
			if (account.getRole() != null) {
				return ;
			}

			Role role = ManagerPool.role.getRole(msg.getId());
			if (role == null) {
				return ;
			}
			
			account.setRole(role);
			ManagerPool.map.enter(role);
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}
