package com.mokylin.game.core.word;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;

public class WordFilter {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(WordFilter.class);
	private volatile Node rootNode;

	public void init(Collection<String> sensitiveWords) {
		rootNode = new Node('R');
		Node.init(sensitiveWords, rootNode);
	}
	
	/**
	 * 获取合法的字符串
	 * @param content
	 * @return
	 */
	public String getLegalString(String content) {
		char[] chars = content.toCharArray();
		Node node = rootNode;
		StringBuffer buffer = new StringBuffer();
		List<String> badList = new ArrayList<String>();
		int a = 0;
		while (a < chars.length) {
			node = Node.findNode(node, chars[a]);
			if (node == null) {
				node = rootNode;
				a = a - badList.size();
				if (badList.size() > 0) {
					badList.clear();
				}
				buffer.append(chars[a]);
			} else if (node.flag == 1) {
				badList.add(String.valueOf(chars[a]));
				for (int i = 0; i < badList.size(); i++) {
					buffer.append("*");
				}
				node = rootNode;
				badList.clear();
			} else {
				badList.add(String.valueOf(chars[a]));
				if (a == chars.length - 1) {
					for (int i = 0; i < badList.size(); i++) {
						buffer.append(badList.get(i));
					}
				}
			}
			a++;
		}
		return buffer.toString();
	}

	/**
	 * 是否包含敏感字符
	 * @param content
	 * @return
	 */
	public boolean isLegal(String content) {
		char[] chars = content.toCharArray();
		Node node = rootNode;
		StringBuffer buffer = new StringBuffer();
		List<String> word = new ArrayList<String>();
		int a = 0;
		while (a < chars.length) {
			node = Node.findNode(node, chars[a]);
			if (node == null) {
				node = rootNode;
				a = a - word.size();
				buffer.append(chars[a]);
				word.clear();
			} else if (node.flag == 1) {
				node = null;
				return true;
			} else {
				word.add(String.valueOf(chars[a]));
			}
			a++;
		}
		chars = null;
		word.clear();
		word = null;
		return false;
	}

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("a");
		set.add("bb");
		set.add("ccc");
		set.add("dddd");
		set.add("eeeee");
		
		WordFilter filter = new WordFilter();
		filter.init(set);
		String str;
		
		str = "dsdfecaddd";
		System.err.println(str + ":" + filter.getLegalString(str));
		str = "fefefggbbdbdsd";
		System.err.println(str + ":" + filter.isLegal(str));
		str = "fsfefeccdsfsf";
		System.err.println(str + ":" + filter.isLegal(str));
		str = "grhtrhthreffddddddddd";
		System.err.println(str + ":" + filter.isLegal(str));
		str = "fefefeeeeefefefe";
		System.err.println(str + ":" + filter.isLegal(str));
	}
}
