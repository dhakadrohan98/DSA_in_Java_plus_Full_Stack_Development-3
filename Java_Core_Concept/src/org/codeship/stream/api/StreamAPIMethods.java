package org.codeship.stream.api;

import java.util.*;
import java.util.stream.Collectors;
public class StreamAPIMethods {

	public static void main(String[] args) {
		//flatMap -> Flatten Nested Structures
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
		System.out.println(nestedList);
		List<Integer> collect = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(collect);
	}	

}
