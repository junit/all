package com.mokylin.game.robot.logic.role.handler;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.util.CommonUtil;
import com.mokylin.game.robot.Robot;
import com.mokylin.game.robot.logic.role.message.ReqRoleCreateMessage;
import com.mokylin.game.robot.logic.role.message.ResRoleInfoMessage;
import com.mokylin.game.robot.logic.role.message.RoleInfo;

public class ResRoleInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResRoleInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResRoleInfoMessage msg = (ResRoleInfoMessage)this.getMessage();
    		if (msg.getRoles().isEmpty()) {
    			ChannelHandlerContext ctx = (ChannelHandlerContext)this.getExcutor();
    			Robot robot = Robot.getRobot(ctx);
    			
    			ReqRoleCreateMessage ret = new ReqRoleCreateMessage();
    			ret.setName(robot.getAccount() + "_role");
    			ret.setSex((byte) CommonUtil.random(0, 1));
    			ctx.writeAndFlush(ret);
    			
    			logger.error("创建角色:" + ret.getName());
    		} else {
    			for (RoleInfo info : msg.getRoles()) {
    				logger.error("收到角色:" + info.getName());
    			}
    		}
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
