package com.moloong.bleach.robot.initer;

import com.game.command.Handler;
import com.moloong.bleach.player.structs.Player;
import com.moloong.bleach.robot.IHandlerIniter;

public class ${short_handler}Initer implements IHandlerIniter {

	@Override
	public void init(Handler handler) {
		${msg} msg = (${msg})handler.getMessage();
		Player player = (Player) handler.getExecutor();
		// TODO 初始化
	}

}
