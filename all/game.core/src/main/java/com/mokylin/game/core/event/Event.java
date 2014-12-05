package com.mokylin.game.core.event;

public final class Event<OWNER, EVENT> {
	private EVENT gameEvent;
	private GameEventHandler<OWNER, EVENT> gameEventHandler;
	private OWNER owner;
	public EVENT getGameEvent() {
		return gameEvent;
	}
	public void setGameEvent(EVENT gameEvent) {
		this.gameEvent = gameEvent;
	}
	public GameEventHandler<OWNER, EVENT> getGameEventHandler() {
		return gameEventHandler;
	}
	public void setGameEventHandler(GameEventHandler<OWNER, EVENT> gameEventHandler) {
		this.gameEventHandler = gameEventHandler;
	}
	public OWNER getOwner() {
		return owner;
	}
	public void setOwner(OWNER owner) {
		this.owner = owner;
	}
}
