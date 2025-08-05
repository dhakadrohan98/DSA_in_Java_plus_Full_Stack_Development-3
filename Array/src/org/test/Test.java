package org.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
//	
//	Given the following list of employee names, write a Java program using Streams and Optional to:
//		 
//		Find the first name starting with the letter "S".
//		 
//		Convert that name to uppercase.
//		 
//		If no such name exists, print "No match found."
//		 
//		List<String> names = Arrays.asList("Alice", "Bob", "Sam", "Steve", "Mary");
//
//		 
//		Answer : SAM

		 
	
	private void psvm() {
		List<String> names=Arrays.asList("Alice","Bob","Sam","Steve","Mary");
		
		Optional<String>result=names.stream().filter(n->n.startsWith("S")).findFirst().map(String::toUpperCase);
		System.out.println(result.orElse("No match Found"));
	}

}
