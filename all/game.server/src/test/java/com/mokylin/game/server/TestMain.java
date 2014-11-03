package com.mokylin.game.server;

import com.alibaba.fastjson.JSON;

class Data {
	private int a;
	private String str;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return "a:" + a + ", str:" + str;
	}
}

public class TestMain {
	public static void main(String[] args) {
		Data data = new Data();
		data.setA(1000);
		data.setStr("abc123");
		String string = JSON.toJSONString(data);
		System.out.println(string);

		long s = System.currentTimeMillis();
		for (int i = 0; i < 1000000; ++i) {
			Data tmp = JSON.parseObject(string, Data.class);
		}
		System.out.println(System.currentTimeMillis() - s);
	}
}
