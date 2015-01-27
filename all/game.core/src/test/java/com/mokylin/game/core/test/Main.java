package com.mokylin.game.core.test;

import java.util.HashSet;


public class Main {
	public static void main(String[] args) {
//		Injector inj = Guice.createInjector(new Module() {
//			@Override
//			public void configure(Binder binder) {
//				binder.bindInterceptor(Matchers.subclassesOf(Service.class), Matchers.any(), new MyMethodInterceptor());
//			}
//		});
//		Service demo = inj.getInstance(Service.class);
//		demo.sayHello();
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		HashSet<String> set = new HashSet<>();
		set.add("a");
		System.out.println(set.contains("a"));
	}
}
