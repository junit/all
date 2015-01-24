package com.mokylin.game.robot.message.manager;

import com.mokylin.game.core.message.MessagePool;

@Singleton
public class MessageManager {

	public boolean init() {
		<#list details as detail>
		MessagePool.getInstance().register(${detail.id?c}, ${detail.pkg}.handler.${detail.name}Handler.class, ${detail.pkg}.message.${detail.name}Message.class);
		</#list>
		return true;
	}
}
