package tool;

import tool.analyzer.HandlerAnalyzer;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("input path");
			return ;
		}
		HandlerAnalyzer analyzer = new HandlerAnalyzer();
		try {
			analyzer.analyze(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
