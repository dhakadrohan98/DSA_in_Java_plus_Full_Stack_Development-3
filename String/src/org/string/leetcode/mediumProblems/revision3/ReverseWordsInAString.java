package org.string.leetcode.mediumProblems.revision3;

public class ReverseWordsInAString {

	// TC: O(n * m) //length of string is n & average length of each character is m
	// SC: O(n * m)
	public String reverseWords(String s) {
		s = s.trim();
		String[] splited = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = splited.length - 1; i >= 0; i--) {
			String str = splited[i];
			if (!str.isEmpty()) {
				sb.append(str);
				if (i != 0) {
					sb.append(" ");
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
