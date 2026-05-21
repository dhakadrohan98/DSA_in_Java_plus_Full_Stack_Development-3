package org.codeship.reflection;

public class Singleton {
	
	private static Singleton obj;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(obj == null) {
			obj = new Singleton();
		}
		return obj;
	}

}
