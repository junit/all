package com.mokylin.game.server.name;

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.mokylin.game.core.word.WordFilter;

public class NameManager {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(NameManager.class);
	// 玩家名字
	private HashSet<String> names = new HashSet<>();
	private HashSet<Character> legalSpecialChar = new HashSet<>();
	private WordFilter wordFilter = new WordFilter();

	public NameManager() {
		super();
		legalSpecialChar.add('_');
	}

	public boolean check(String name) {
		// 要求为汉字,英文,数字,以及允许的特殊字符
		for (char c : name.toCharArray()) {
			if (!isChinese(c) && !Character.isDigit(c) && !Character.isLetter(c) && !legalSpecialChar.contains(c)) {
				return false;
			}
		}

		if (!isLegal(name)) {
			return false;
		}

		synchronized (names) {
			if (names.contains(name)) {
				return false;
			}

			names.add(name);
		}
		return true;
	}

	private boolean isChinese(char c) {
		int v = (int) c;
		return (v >= 0x4e00 && v <= 0x9fa5);
	}

	/**
	 * 字符串是否合法(不存在政府部门不允许的字符)
	 * 
	 * @param str
	 * @return
	 */
	private boolean isLegal(String str) {
		return wordFilter.isLegal(str);
	}

	public boolean init() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("草拟吗");
		wordFilter.init(list);
		return true;
	}

	/**
	 * 根据name和server生成一个合法的name,如果没有则返回null
	 * @param server
	 * @param name
	 * @return
	 */
	public String createValidName(int server, String name) {
		String newName = new StringBuilder().append(server).append(".").append(name).toString();
		return check(newName) ? newName : null;
	}
}
