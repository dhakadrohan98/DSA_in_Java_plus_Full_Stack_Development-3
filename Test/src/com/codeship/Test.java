package com.codeship;

public class Test {

	public static String sayHello(String name) {
		return "hi " + name;
	}

	public static void main(String[] args) {
		String res = sayHello("Rohan");
		System.out.println(res);
	}

}
