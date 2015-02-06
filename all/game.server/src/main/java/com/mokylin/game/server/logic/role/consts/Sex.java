package com.mokylin.game.server.logic.role.consts;

public enum Sex {
	MALE((byte)0),
	FEMALE((byte)1),
	;
	
	private byte value;
	Sex(byte value) {
		this.value = value;
	}
	public byte getValue() {
		return value;
	}
	
	public static Sex get(byte sex) {
		switch (sex) {
		case 0:
			return MALE;
		}
		return FEMALE;
	}
}
