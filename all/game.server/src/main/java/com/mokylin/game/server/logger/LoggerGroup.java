package com.mokylin.game.server.logger;

import org.apache.log4j.Logger;

import com.google.inject.Singleton;

@Singleton
public class LoggerGroup {
	public Logger db = Logger.getLogger("DB_LOG");
}
