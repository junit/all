package com.mokylin.game.server;

import com.mokylin.game.core.message.MessagePool;

public class MessageManager {
	public boolean init() {
		MessagePool.getInstance().register(101201, com.mokylin.game.server.logic.role.handler.ResRoleInfoHandler.class, com.mokylin.game.server.logic.role.message.ResRoleInfoMessage.class);
		MessagePool.getInstance().register(101202, com.mokylin.game.server.logic.role.handler.ResRoleCreateHandler.class, com.mokylin.game.server.logic.role.message.ResRoleCreateMessage.class);
		MessagePool.getInstance().register(100201, com.mokylin.game.server.logic.account.handler.ResAccountLoginFailedHandler.class, com.mokylin.game.server.logic.account.message.ResAccountLoginFailedMessage.class);
		MessagePool.getInstance().register(102201, com.mokylin.game.server.logic.map.handler.ResMapAllObjectHandler.class, com.mokylin.game.server.logic.map.message.ResMapAllObjectMessage.class);
		MessagePool.getInstance().register(100202, com.mokylin.game.server.logic.account.handler.ResAccountTestHandler.class, com.mokylin.game.server.logic.account.message.ResAccountTestMessage.class);
		MessagePool.getInstance().register(102202, com.mokylin.game.server.logic.map.handler.ResMapRoleHandler.class, com.mokylin.game.server.logic.map.message.ResMapRoleMessage.class);
		return true;
	}
}
