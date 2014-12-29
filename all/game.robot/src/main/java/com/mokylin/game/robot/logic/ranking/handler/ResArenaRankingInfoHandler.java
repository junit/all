package com.mokylin.game.robot.logic.ranking.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.ranking.message.ResArenaRankingInfoMessage;

public class ResArenaRankingInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResArenaRankingInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResArenaRankingInfoMessage msg = (ResArenaRankingInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
