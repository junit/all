package com.mokylin.game.core.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	public static void main(String[] args) {{
        Logger logger = LoggerFactory.getLogger("test");
        try {
            throw new Exception();
        } catch (Exception e) {
            logger.error(e.getSuppressed().toString());
        }
    }}
}
