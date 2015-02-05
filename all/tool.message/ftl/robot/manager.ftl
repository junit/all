package com.mokylin.game.robot;

import com.mokylin.game.core.message.MessagePool;

public class MessageManager {
	public boolean init() {<#list details as detail>
		MessagePool.getInstance().register(${detail.id?c}, com.mokylin.game.robot.logic.${detail.pkg}.handler.${detail.name}Handler.class, com.mokylin.game.robot.logic.${detail.pkg}.message.${detail.name}Message.class);</#list>
		return true;
	}
}
