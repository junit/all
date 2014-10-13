package com.mokylin.game.robot.logic.ranking.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.ranking.message.ResArenaRankingUpdateMessage;

public class ResArenaRankingUpdateHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResArenaRankingUpdateHandler.class);
    @Override
    public void exec() {
    	try {
    		ResArenaRankingUpdateMessage msg = (ResArenaRankingUpdateMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
