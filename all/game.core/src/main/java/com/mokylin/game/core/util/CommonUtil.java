package com.mokylin.game.core.util;

import java.util.concurrent.ThreadLocalRandom;

public class CommonUtil {
	public static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
