package com.mokylin.game.robot.logic.login.handler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.robot.RobotClient;
import com.mokylin.game.robot.logic.login.message.ReqCreatePlayerMessage;
import com.mokylin.game.robot.logic.login.message.ResLoginResultMessage;

public class ResLoginResultHandler extends Handler {
	private static Logger logger = Logger.getLogger(ResLoginResultHandler.class);

	@Override
	public void exec() {
		try {
			ResLoginResultMessage msg = (ResLoginResultMessage) this.getMessage();
			RobotClient client = RobotClient.get(this.getContext());
			
			if (msg.getIsSuccess() == 0) {
				if (msg.getHavePlayer() == 0) {
					ReqCreatePlayerMessage ret = new ReqCreatePlayerMessage();
					ret.setName(client.getName());
					this.getContext().writeAndFlush(ret);
				} else {
				}
			}
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}
