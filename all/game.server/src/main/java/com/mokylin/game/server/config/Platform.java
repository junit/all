package com.mokylin.game.server.config;

public enum Platform {
	ILLEGAL(0),
	;
	private int value;
	private Platform(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public static Platform get(int value) {
		switch (value) {
		}
		return ILLEGAL;
	}
}
