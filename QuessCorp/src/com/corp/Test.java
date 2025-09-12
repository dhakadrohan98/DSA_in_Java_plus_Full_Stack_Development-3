package com.corp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Write a lambda expression to sort a list of strings by their length
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("str1");
		list.add("str2us");
		list.add("str");
//		Collections.sort(list, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
		Collections.sort(list, (s1, s2) -> s2.length() - s1.length());
		System.out.println(list);
	}

}
