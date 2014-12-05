package com.mokylin.game.core.event;

public class EventHandler<OWNER, EVENT> implements com.lmax.disruptor.EventHandler<Event<OWNER, EVENT>> {

	@Override
	public void onEvent(Event<OWNER, EVENT> event, long sequence, boolean endOfBatch) throws Exception {
		event.getGameEventHandler().onEvent(event.getOwner(), event.getGameEvent());
	}

}
