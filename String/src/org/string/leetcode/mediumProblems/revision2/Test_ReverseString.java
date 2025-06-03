package org.string.leetcode.mediumProblems.revision2;

public class Test_ReverseString {
	
	public static void main(String[] args) {
		  String str = "123";

		  System.out.println(sample(str)); 
		 }

		 public static String sample(String in) {
		  if (in == null)
		   throw new IllegalArgumentException("Null is not valid input");

		  StringBuilder out = new StringBuilder();

		  char[] chars = in.toCharArray();

		  for (int i = chars.length - 1; i >= 0; i--)
		   out.append(chars[i]);

		  return out.toString();
		 }
}
