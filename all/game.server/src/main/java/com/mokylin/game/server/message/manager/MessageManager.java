package com.mokylin.game.server.message.manager;

import com.mokylin.game.core.message.MessagePool;

public class MessageManager {

	public boolean init() {
		MessagePool.getInstance().register(212101, com.mokylin.game.server.logic.lottery.handler.ReqStartLotteryHandler.class, com.mokylin.game.server.logic.lottery.message.ReqStartLotteryMessage.class);
		MessagePool.getInstance().register(104201, com.mokylin.game.server.logic.shop.handler.ReqShopInfoHandler.class, com.mokylin.game.server.logic.shop.message.ReqShopInfoMessage.class);
		MessagePool.getInstance().register(104203, com.mokylin.game.server.logic.shop.handler.ReqShopRefreshHandler.class, com.mokylin.game.server.logic.shop.message.ReqShopRefreshMessage.class);
		MessagePool.getInstance().register(104202, com.mokylin.game.server.logic.shop.handler.ReqShopBuyHandler.class, com.mokylin.game.server.logic.shop.message.ReqShopBuyMessage.class);
		MessagePool.getInstance().register(105104, com.mokylin.game.server.logic.player.handler.ReqPlayerGmHandler.class, com.mokylin.game.server.logic.player.message.ReqPlayerGmMessage.class);
		MessagePool.getInstance().register(301201, com.mokylin.game.server.logic.training.handler.ReqRefreshTrainingHandler.class, com.mokylin.game.server.logic.training.message.ReqRefreshTrainingMessage.class);
		MessagePool.getInstance().register(301202, com.mokylin.game.server.logic.training.handler.ReqEnterTrainingHandler.class, com.mokylin.game.server.logic.training.message.ReqEnterTrainingMessage.class);
		MessagePool.getInstance().register(210201, com.mokylin.game.server.logic.achievement.handler.ReqAchievementRewardHandler.class, com.mokylin.game.server.logic.achievement.message.ReqAchievementRewardMessage.class);
		MessagePool.getInstance().register(211103, com.mokylin.game.server.logic.butterfly.handler.ReqEndButterflyHandler.class, com.mokylin.game.server.logic.butterfly.message.ReqEndButterflyMessage.class);
		MessagePool.getInstance().register(211102, com.mokylin.game.server.logic.butterfly.handler.ReqStartButterflyHandler.class, com.mokylin.game.server.logic.butterfly.message.ReqStartButterflyMessage.class);
		MessagePool.getInstance().register(211101, com.mokylin.game.server.logic.butterfly.handler.ReqEnterButterflyHandler.class, com.mokylin.game.server.logic.butterfly.message.ReqEnterButterflyMessage.class);
		MessagePool.getInstance().register(103201, com.mokylin.game.server.logic.equip.handler.ReqEquipLevelUpHandler.class, com.mokylin.game.server.logic.equip.message.ReqEquipLevelUpMessage.class);
		MessagePool.getInstance().register(211106, com.mokylin.game.server.logic.butterfly.handler.ReqIsButterflyOpenHandler.class, com.mokylin.game.server.logic.butterfly.message.ReqIsButterflyOpenMessage.class);
		MessagePool.getInstance().register(211105, com.mokylin.game.server.logic.butterfly.handler.ReqButterflyFightNowHandler.class, com.mokylin.game.server.logic.butterfly.message.ReqButterflyFightNowMessage.class);
		MessagePool.getInstance().register(211104, com.mokylin.game.server.logic.butterfly.handler.ReqChangeButterflyOpponentHandler.class, com.mokylin.game.server.logic.butterfly.message.ReqChangeButterflyOpponentMessage.class);
		MessagePool.getInstance().register(200103, com.mokylin.game.server.logic.character.handler.ReqCharacterStageResetHandler.class, com.mokylin.game.server.logic.character.message.ReqCharacterStageResetMessage.class);
		MessagePool.getInstance().register(200102, com.mokylin.game.server.logic.character.handler.ReqCharacterStageUpHandler.class, com.mokylin.game.server.logic.character.message.ReqCharacterStageUpMessage.class);
		MessagePool.getInstance().register(200101, com.mokylin.game.server.logic.character.handler.ReqUnLockCharacterHandler.class, com.mokylin.game.server.logic.character.message.ReqUnLockCharacterMessage.class);
		MessagePool.getInstance().register(108201, com.mokylin.game.server.logic.girl.handler.ReqGirlInfoHandler.class, com.mokylin.game.server.logic.girl.message.ReqGirlInfoMessage.class);
		MessagePool.getInstance().register(204203, com.mokylin.game.server.logic.soultrial.handler.ReqAddSoulTrialCountHandler.class, com.mokylin.game.server.logic.soultrial.message.ReqAddSoulTrialCountMessage.class);
		MessagePool.getInstance().register(204202, com.mokylin.game.server.logic.soultrial.handler.ReqCompleteSoulTrialHandler.class, com.mokylin.game.server.logic.soultrial.message.ReqCompleteSoulTrialMessage.class);
		MessagePool.getInstance().register(108203, com.mokylin.game.server.logic.girl.handler.ReqGirlDressHandler.class, com.mokylin.game.server.logic.girl.message.ReqGirlDressMessage.class);
		MessagePool.getInstance().register(204201, com.mokylin.game.server.logic.soultrial.handler.ReqStartSoulTrialHandler.class, com.mokylin.game.server.logic.soultrial.message.ReqStartSoulTrialMessage.class);
		MessagePool.getInstance().register(108202, com.mokylin.game.server.logic.girl.handler.ReqGirlDateHandler.class, com.mokylin.game.server.logic.girl.message.ReqGirlDateMessage.class);
		MessagePool.getInstance().register(108205, com.mokylin.game.server.logic.girl.handler.ReqGirlGetGirlHandler.class, com.mokylin.game.server.logic.girl.message.ReqGirlGetGirlMessage.class);
		MessagePool.getInstance().register(108204, com.mokylin.game.server.logic.girl.handler.ReqGirlGetInfoHandler.class, com.mokylin.game.server.logic.girl.message.ReqGirlGetInfoMessage.class);
		MessagePool.getInstance().register(204206, com.mokylin.game.server.logic.soultrial.handler.ReqRestartSoulTrialHandler.class, com.mokylin.game.server.logic.soultrial.message.ReqRestartSoulTrialMessage.class);
		MessagePool.getInstance().register(300201, com.mokylin.game.server.logic.spa.handler.ReqEnterSpaHandler.class, com.mokylin.game.server.logic.spa.message.ReqEnterSpaMessage.class);
		MessagePool.getInstance().register(108207, com.mokylin.game.server.logic.girl.handler.ReqGirlDisableAssistSkillHandler.class, com.mokylin.game.server.logic.girl.message.ReqGirlDisableAssistSkillMessage.class);
		MessagePool.getInstance().register(204205, com.mokylin.game.server.logic.soultrial.handler.ReqGetAllSoulTrialRewardHandler.class, com.mokylin.game.server.logic.soultrial.message.ReqGetAllSoulTrialRewardMessage.class);
		MessagePool.getInstance().register(300202, com.mokylin.game.server.logic.spa.handler.ReqUseVitalityHandler.class, com.mokylin.game.server.logic.spa.message.ReqUseVitalityMessage.class);
		MessagePool.getInstance().register(108206, com.mokylin.game.server.logic.girl.handler.ReqGirlEnableAssistSkillHandler.class, com.mokylin.game.server.logic.girl.message.ReqGirlEnableAssistSkillMessage.class);
		MessagePool.getInstance().register(204204, com.mokylin.game.server.logic.soultrial.handler.ReqGetOneSoulTrialRewardHandler.class, com.mokylin.game.server.logic.soultrial.message.ReqGetOneSoulTrialRewardMessage.class);
		MessagePool.getInstance().register(305201, com.mokylin.game.server.logic.signin.handler.ReqSigninHandler.class, com.mokylin.game.server.logic.signin.message.ReqSigninMessage.class);
		MessagePool.getInstance().register(102201, com.mokylin.game.server.logic.level.handler.ReqEnterLevelHandler.class, com.mokylin.game.server.logic.level.message.ReqEnterLevelMessage.class);
		MessagePool.getInstance().register(102203, com.mokylin.game.server.logic.level.handler.ReqMopHandler.class, com.mokylin.game.server.logic.level.message.ReqMopMessage.class);
		MessagePool.getInstance().register(102202, com.mokylin.game.server.logic.level.handler.ReqCompleteLevelHandler.class, com.mokylin.game.server.logic.level.message.ReqCompleteLevelMessage.class);
		MessagePool.getInstance().register(107201, com.mokylin.game.server.logic.destiny.handler.ReqDestinyInfoHandler.class, com.mokylin.game.server.logic.destiny.message.ReqDestinyInfoMessage.class);
		MessagePool.getInstance().register(107203, com.mokylin.game.server.logic.destiny.handler.ReqDestinyPrizeHandler.class, com.mokylin.game.server.logic.destiny.message.ReqDestinyPrizeMessage.class);
		MessagePool.getInstance().register(107202, com.mokylin.game.server.logic.destiny.handler.ReqDestinyFightHandler.class, com.mokylin.game.server.logic.destiny.message.ReqDestinyFightMessage.class);
		MessagePool.getInstance().register(107204, com.mokylin.game.server.logic.destiny.handler.ReqDestinyRefreshHandler.class, com.mokylin.game.server.logic.destiny.message.ReqDestinyRefreshMessage.class);
		MessagePool.getInstance().register(304201, com.mokylin.game.server.logic.soulability.handler.ReqSoulAbilityUpgradeHandler.class, com.mokylin.game.server.logic.soulability.message.ReqSoulAbilityUpgradeMessage.class);
		MessagePool.getInstance().register(304202, com.mokylin.game.server.logic.soulability.handler.ReqBuySkillPointHandler.class, com.mokylin.game.server.logic.soulability.message.ReqBuySkillPointMessage.class);
		MessagePool.getInstance().register(213202, com.mokylin.game.server.logic.freshguide.handler.ReqSaveFreshGuideHandler.class, com.mokylin.game.server.logic.freshguide.message.ReqSaveFreshGuideMessage.class);
		MessagePool.getInstance().register(501201, com.mokylin.game.server.logic.playersync.handler.ReqPlayerSyncHandler.class, com.mokylin.game.server.logic.playersync.message.ReqPlayerSyncMessage.class);
		MessagePool.getInstance().register(106201, com.mokylin.game.server.logic.food.handler.ReqFoodCookHandler.class, com.mokylin.game.server.logic.food.message.ReqFoodCookMessage.class);
		MessagePool.getInstance().register(106203, com.mokylin.game.server.logic.food.handler.ReqFoodClearTimeHandler.class, com.mokylin.game.server.logic.food.message.ReqFoodClearTimeMessage.class);
		MessagePool.getInstance().register(106202, com.mokylin.game.server.logic.food.handler.ReqFoodDigestHandler.class, com.mokylin.game.server.logic.food.message.ReqFoodDigestMessage.class);
		MessagePool.getInstance().register(400102, com.mokylin.game.server.logic.fighting.handler.ReqEndFightingHandler.class, com.mokylin.game.server.logic.fighting.message.ReqEndFightingMessage.class);
		MessagePool.getInstance().register(207201, com.mokylin.game.server.logic.exchange.handler.ReqSoulExchangeHandler.class, com.mokylin.game.server.logic.exchange.message.ReqSoulExchangeMessage.class);
		MessagePool.getInstance().register(400101, com.mokylin.game.server.logic.fighting.handler.ReqStartFightingHandler.class, com.mokylin.game.server.logic.fighting.message.ReqStartFightingMessage.class);
		MessagePool.getInstance().register(303201, com.mokylin.game.server.logic.discovery.handler.ReqBeginDiscoveryHandler.class, com.mokylin.game.server.logic.discovery.message.ReqBeginDiscoveryMessage.class);
		MessagePool.getInstance().register(303202, com.mokylin.game.server.logic.discovery.handler.ReqReceiveDiscoveryRewardHandler.class, com.mokylin.game.server.logic.discovery.message.ReqReceiveDiscoveryRewardMessage.class);
		MessagePool.getInstance().register(100201, com.mokylin.game.server.logic.login.handler.ReqLoginHandler.class, com.mokylin.game.server.logic.login.message.ReqLoginMessage.class);
		MessagePool.getInstance().register(100202, com.mokylin.game.server.logic.login.handler.ReqCreatePlayerHandler.class, com.mokylin.game.server.logic.login.message.ReqCreatePlayerMessage.class);
		MessagePool.getInstance().register(500203, com.mokylin.game.server.logic.mail.handler.ReqDeleteMailHandler.class, com.mokylin.game.server.logic.mail.message.ReqDeleteMailMessage.class);
		MessagePool.getInstance().register(500202, com.mokylin.game.server.logic.mail.handler.ReqGetMailAttachHandler.class, com.mokylin.game.server.logic.mail.message.ReqGetMailAttachMessage.class);
		MessagePool.getInstance().register(500201, com.mokylin.game.server.logic.mail.handler.ReqReadMailHandler.class, com.mokylin.game.server.logic.mail.message.ReqReadMailMessage.class);
		MessagePool.getInstance().register(105201, com.mokylin.game.server.logic.player.handler.ReqPlayerTestHandler.class, com.mokylin.game.server.logic.player.message.ReqPlayerTestMessage.class);
		MessagePool.getInstance().register(105202, com.mokylin.game.server.logic.player.handler.ReqPlayerSkillPointRecoverHandler.class, com.mokylin.game.server.logic.player.message.ReqPlayerSkillPointRecoverMessage.class);
		MessagePool.getInstance().register(206203, com.mokylin.game.server.logic.arena.handler.ReqStartArenaHandler.class, com.mokylin.game.server.logic.arena.message.ReqStartArenaMessage.class);
		MessagePool.getInstance().register(206202, com.mokylin.game.server.logic.arena.handler.ReqChangeArenaOpponentHandler.class, com.mokylin.game.server.logic.arena.message.ReqChangeArenaOpponentMessage.class);
		MessagePool.getInstance().register(206201, com.mokylin.game.server.logic.arena.handler.ReqEnterArenaHandler.class, com.mokylin.game.server.logic.arena.message.ReqEnterArenaMessage.class);
		MessagePool.getInstance().register(206206, com.mokylin.game.server.logic.arena.handler.ReqFightNowHandler.class, com.mokylin.game.server.logic.arena.message.ReqFightNowMessage.class);
		MessagePool.getInstance().register(302201, com.mokylin.game.server.logic.millionluck.handler.ReqLuckHandler.class, com.mokylin.game.server.logic.millionluck.message.ReqLuckMessage.class);
		MessagePool.getInstance().register(206205, com.mokylin.game.server.logic.arena.handler.ReqAddArenaCountHandler.class, com.mokylin.game.server.logic.arena.message.ReqAddArenaCountMessage.class);
		MessagePool.getInstance().register(302202, com.mokylin.game.server.logic.millionluck.handler.ReqReceiveMillionLuckRewardHandler.class, com.mokylin.game.server.logic.millionluck.message.ReqReceiveMillionLuckRewardMessage.class);
		MessagePool.getInstance().register(206204, com.mokylin.game.server.logic.arena.handler.ReqEndArenaHandler.class, com.mokylin.game.server.logic.arena.message.ReqEndArenaMessage.class);
		return true;
	}
}
