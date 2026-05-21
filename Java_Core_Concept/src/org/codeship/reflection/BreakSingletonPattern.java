package org.codeship.reflection;

import java.lang.reflect.Constructor;

public class BreakSingletonPattern {

	public static void main(String[] args) throws Exception{
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println();
		
		Constructor<Singleton> c = Singleton.class.getDeclaredConstructor();
		c.setAccessible(true);
		
		s1 = c.newInstance();
		s2 = c.newInstance();
		System.out.println(s1.hashCode() + " != " + s2.hashCode());
		
	}

}
