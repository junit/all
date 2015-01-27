package com.mokylin.game.robot.message;

import com.mokylin.game.core.message.MessagePool;

public class MessageManager {
	
	public boolean init() {
		MessagePool.getInstance().register(100101, com.mokylin.game.robot.logic.login.handler.ResLoginResultHandler.class, com.mokylin.game.robot.logic.login.message.ResLoginResultMessage.class);
		MessagePool.getInstance().register(100103, com.mokylin.game.robot.logic.login.handler.ResPlayerBaseInfoHandler.class, com.mokylin.game.robot.logic.login.message.ResPlayerBaseInfoMessage.class);
		MessagePool.getInstance().register(100102, com.mokylin.game.robot.logic.login.handler.ResCreatePlayerResultHandler.class, com.mokylin.game.robot.logic.login.message.ResCreatePlayerResultMessage.class);
		MessagePool.getInstance().register(100105, com.mokylin.game.robot.logic.login.handler.ResGameStartHandler.class, com.mokylin.game.robot.logic.login.message.ResGameStartMessage.class);
		MessagePool.getInstance().register(100104, com.mokylin.game.robot.logic.login.handler.ResContinuousLoginHandler.class, com.mokylin.game.robot.logic.login.message.ResContinuousLoginMessage.class);
		MessagePool.getInstance().register(105101, com.mokylin.game.robot.logic.player.handler.ResPlayerAttrChangeHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerAttrChangeMessage.class);
		MessagePool.getInstance().register(105103, com.mokylin.game.robot.logic.player.handler.ResPlayerAttributeHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerAttributeMessage.class);
		MessagePool.getInstance().register(105102, com.mokylin.game.robot.logic.player.handler.ResPlayerAttributesHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerAttributesMessage.class);
		MessagePool.getInstance().register(105105, com.mokylin.game.robot.logic.player.handler.ResRecoverHealthHandler.class, com.mokylin.game.robot.logic.player.message.ResRecoverHealthMessage.class);
		MessagePool.getInstance().register(105107, com.mokylin.game.robot.logic.player.handler.ResPlayerActivityDiscountHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerActivityDiscountMessage.class);
		MessagePool.getInstance().register(105106, com.mokylin.game.robot.logic.player.handler.ResPlayerGmHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerGmMessage.class);
		MessagePool.getInstance().register(105109, com.mokylin.game.robot.logic.player.handler.ResPlayerSkillPointRecoverHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerSkillPointRecoverMessage.class);
		MessagePool.getInstance().register(105108, com.mokylin.game.robot.logic.player.handler.ResPlayerTestHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerTestMessage.class);
		MessagePool.getInstance().register(105110, com.mokylin.game.robot.logic.player.handler.ResPlayerHealthRecoverHandler.class, com.mokylin.game.robot.logic.player.message.ResPlayerHealthRecoverMessage.class);
		return true;
	}
}
