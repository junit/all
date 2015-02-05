package com.mokylin.game.core.message;

public interface Command {
	 public void exec();
	 /*
	  * 超时毫秒数
	  */
	 public default int timeOutMs() {
		 return 5;
	 }
}
