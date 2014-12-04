package com.mokylin.game.core.event;

import com.lmax.disruptor.EventHandler;

public interface GameEventHandler<T extends GameEvent> extends EventHandler<T> {

}
