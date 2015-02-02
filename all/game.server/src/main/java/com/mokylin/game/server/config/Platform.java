package com.mokylin.game.server.config;

public enum Platform {
	ALL(0),
	;
	private int value;
	private Platform(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public static Platform get(int value) {
		// TODO Auto-generated method stub
		return null;
	}
}
