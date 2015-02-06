package com.mokylin.game.server;

import com.mokylin.game.core.message.MessagePool;

public class MessageManager {
	public boolean init() {
		MessagePool.getInstance().register(100101, com.mokylin.game.server.logic.account.handler.ReqAccountLoginHandler.class, com.mokylin.game.server.logic.account.message.ReqAccountLoginMessage.class);
		MessagePool.getInstance().register(102101, com.mokylin.game.server.logic.map.handler.ReqMapEnterHandler.class, com.mokylin.game.server.logic.map.message.ReqMapEnterMessage.class);
		MessagePool.getInstance().register(100102, com.mokylin.game.server.logic.account.handler.ReqAccountTestHandler.class, com.mokylin.game.server.logic.account.message.ReqAccountTestMessage.class);
		MessagePool.getInstance().register(101101, com.mokylin.game.server.logic.role.handler.ReqRoleCreateHandler.class, com.mokylin.game.server.logic.role.message.ReqRoleCreateMessage.class);
		return true;
	}
}
