package com.mokylin.game.server.logic.account.consts;

public enum RetCode {
	LOGINED((byte)1),
	SERVER_ERROR((byte)1),
	CRATE_ERROR((byte)1),
	KEY_ERROR((byte)1),
	;
	private byte value;
	RetCode(byte value) {
		this.value = value;
	}
	public byte getValue() {
		return value;
	}
}
