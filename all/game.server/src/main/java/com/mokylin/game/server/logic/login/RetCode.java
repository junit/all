package com.mokylin.game.server.logic.login;

public enum RetCode {
	CRATE_ERROR((byte)1), // 创建非法
	KEY_ERROR((byte)2), // 错误的验证key
	LOGINED((byte)3), // 已经登录
	SERVER_ERROR((byte)4), // 没得这个服务器
	;

	private byte value;
	RetCode(byte value) {
		this.value = value;
	}
	public byte getValue() {
		return value;
	}
}
