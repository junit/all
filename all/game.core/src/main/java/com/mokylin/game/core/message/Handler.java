package com.mokylin.game.core.message;

import com.mokylin.game.core.event.GameEvent;

public abstract class Handler implements GameEvent {
	private Message message; // message
	private Object excutor;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Object getExcutor() {
		return excutor;
	}

	public void setExcutor(Object excutor) {
		this.excutor = excutor;
	}
}
