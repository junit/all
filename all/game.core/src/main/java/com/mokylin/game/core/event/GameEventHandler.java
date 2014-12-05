package com.mokylin.game.core.event;

public interface GameEventHandler<OWNER, EVENT> {
	public void onEvent(OWNER owner, EVENT event);
}
