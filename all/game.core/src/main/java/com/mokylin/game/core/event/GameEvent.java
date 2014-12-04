package com.mokylin.game.core.event;

public interface GameEvent {
	 public void exec() throws Exception;
	 /*
	  * 超时毫秒数
	  */
	 public default int timeOutMs() {
		 return 1;
	 }
}
