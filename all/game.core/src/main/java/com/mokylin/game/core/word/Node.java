package com.mokylin.game.core.word;

import java.util.Collection;
import java.util.HashMap;

public class Node {

	public char c;
	public int flag;
	public HashMap<String, Node> nodes = new HashMap<String, Node>();

	public Node(char c) {
		this.c = c;
		this.flag = 0;
	}

	public Node(char c, int flag) {
		this.c = c;
		this.flag = flag;
	}

	public static Node findNode(Node node, char c) {
		return node.nodes.get(String.valueOf(c));
	}
	
	public static void init(Collection<String> sensitiveWords, Node rootNode) {
		for (String str : sensitiveWords) {
			char[] chars = str.toCharArray();
			if (chars.length > 0)
				insertNode(rootNode, chars, 0);
		}
	}
	
	private static void insertNode(Node node, char[] cs, int index) {
		Node n = Node.findNode(node, cs[index]);
		if (n == null) {
			n = new Node(cs[index]);
			node.nodes.put(String.valueOf(cs[index]), n);
		}

		if (index == (cs.length - 1))
			n.flag = 1;

		index++;
		if (index < cs.length)
			insertNode(n, cs, index);
	}
}
