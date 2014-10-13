package com.mokylin.game.robot.logic.login.handler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.robot.RobotClient;
import com.mokylin.game.robot.logic.login.message.ReqCreatePlayerMessage;
import com.mokylin.game.robot.logic.login.message.ResLoginResultMessage;

public class ResLoginResultHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLoginResultHandler.class);
    @Override
    public void exec() {
    	try {
    		ResLoginResultMessage msg = (ResLoginResultMessage)this.getMessage();
    		if (msg.getIsSuccess() == 0) {
    			if (msg.getHavePlayer() == 0) {
    				RobotClient robot = RobotClient.get(this.getContext());
    				
    				ReqCreatePlayerMessage ret = new ReqCreatePlayerMessage();
    				ret.setName(robot.getName());
    				this.getContext().writeAndFlush(ret);
    			} else if (msg.getHavePlayer() == 1) {
    			}
    		} else {
    			logger.error("失败:" + msg.getIsSuccess());
    		}
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
