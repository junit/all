package com.mokylin.game.core.message;


/**
 * Created by game on 3/31/14.
 */
public abstract class Handler implements Command {
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
