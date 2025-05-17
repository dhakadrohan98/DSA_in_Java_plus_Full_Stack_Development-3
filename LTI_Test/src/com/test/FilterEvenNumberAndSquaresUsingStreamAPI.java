package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumberAndSquaresUsingStreamAPI {

	//Q.1) What is Immutable class?
	// Make class as final
	// private & final fields (mutable -> list or Date)
	// list = new ArrayList<>(customObj);
	// public constructor()
	// getters -> copy of object (in case of mutable objects)

	//Q.2 filter even number and square this number and find the sum
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(10);
		list.add("Test");
		list.add(101);
		list.add(2);
		list.add(33);
		list.add("AAAA");

		int sumOfSquares = list.stream().
				filter(obj -> obj instanceof Integer) // Keep only Integers
				.map(obj -> (Integer) obj) // Cast to Integer
				.filter(num -> num % 2 == 0) // Filter even numbers
				.map(num -> num * num) // Square the number
				.collect(Collectors.summingInt(Integer::intValue)); // Sum using collect

		System.out.println("Sum of squares of even numbers: " + sumOfSquares);

//        list.stream()
//        .filter(e -> {
//        	if(e.getClass() != "".getClass()) {
//        		if((Integer)e % 2 == 0) {
//        			e = e;
//        		}
//        	}
//        }).Collect(Collectors.summarizingInt(e -> e*e));

	}

}
