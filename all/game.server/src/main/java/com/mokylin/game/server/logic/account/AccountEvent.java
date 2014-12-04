package com.mokylin.game.server.logic.account;

import java.util.List;

import org.apache.log4j.Logger;

import com.mokylin.game.core.event.GameEvent;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.db.data.DaoPool;
import com.mokylin.game.server.db.data.bean.RoleBean;
import com.mokylin.game.server.logic.role.Role;

public class AccountEvent {
	private Logger logger = Logger.getLogger(this.getClass());

	public void onLogin(final Account account) {
		account.setOnline(true);
		ManagerPool.thread.getAccountThreadGroup().add(account);

		List<Role> roles = ManagerPool.role.getRoles(account);
		if (roles == null) {
			try {
				ManagerPool.thread.getLoadThreadGroup().add(account, new GameEvent() {
					@Override
					public void exec() throws Exception {
						if (ManagerPool.role.getRoles(account) != null) {
							return ;
						}
						
						final List<RoleBean> list = DaoPool.roleDao.selectByAccount(account.getId());
						
						ManagerPool.thread.getAccountThreadGroup().add(account, new GameEvent() {
							@Override
							public void exec() {
								ManagerPool.role.put(account, list);
								ManagerPool.account.send(account);
							}
						});
					}

					@Override
					public int timeOutMs() {
						return 10;
					}
				});
			} catch (Exception e) {
				logger.error(e, e);
			}
		} else {
			ManagerPool.account.send(account);
		}
	}
}
