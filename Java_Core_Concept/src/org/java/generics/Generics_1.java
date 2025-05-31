package org.java.generics;

class GenericsClass<T> {

	private T data;

	public GenericsClass(T data) {
		this.data = data;
	}
	
	public void set(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
}

class GenericsMethod {

	public <T> void genericMethod(T data) {
		System.out.println("Generic method");
		System.out.println("Data passed: " + data);
	}

}

public class Generics_1 {

	public static void main(String[] args) {
		GenericsClass<Integer> obj1 = new GenericsClass<>(5);
		System.out.println(obj1.getData());

		GenericsClass<String> obj2 = new GenericsClass<>("DSA in java");
		System.out.println(obj2.getData());
		System.out.println();

		GenericsMethod obj3 = new GenericsMethod();
		obj3.<String>genericMethod("Machine coding round using java");
		System.out.println();
		obj3.<Integer>genericMethod(25);

	}

}
