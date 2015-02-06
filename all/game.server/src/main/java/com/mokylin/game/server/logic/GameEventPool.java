package com.mokylin.game.server.logic;

import com.mokylin.game.server.logic.account.AccountEvent;
import com.mokylin.game.server.logic.map.MapEvent;

public class GameEventPool {
	public static AccountEvent account = new AccountEvent();
	public static MapEvent map = new MapEvent();
}
