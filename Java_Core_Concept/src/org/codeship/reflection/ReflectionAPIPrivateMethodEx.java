package org.codeship.reflection;

import java.lang.reflect.Method;

class PrivateMethods {
	
	private void show() {
        System.out.println("Private method m2");
    }
}

public class ReflectionAPIPrivateMethodEx {
	
	public static void main(String[] args) throws Exception{
		PrivateMethods privateMethodsObj = new PrivateMethods();
		
		Method m  = privateMethodsObj.getClass().getDeclaredMethod("show");
		m.setAccessible(true);
		m.invoke(privateMethodsObj);
	}

}
