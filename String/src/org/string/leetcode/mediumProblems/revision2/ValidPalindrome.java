package org.string.leetcode.mediumProblems.revision2;

public class ValidPalindrome {

	// TC: O(n) + O(n) + O(n) + O(n/2)
	// SC: O(3*n)
	public boolean isPalindrome(String s) {
		s = s.trim();
		s = s.toLowerCase();
		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			String ss = str[i];
			for (char ch : ss.toCharArray()) {
				// check current character is alphanumeric or not
				if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
					sb.append(ch);
				}
			}
		}
		String temp = sb.toString();
		return isPalindromeTrue(temp);
	}

	private boolean isPalindromeTrue(String temp) {
		int n = temp.length();
		int i = 0;
		int j = n - 1;

		while (i < j) {
			char frontCh = temp.charAt(i);
			char backCh = temp.charAt(j);
			if (frontCh != backCh)
				return false;
			i += 1;
			j -= 1;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
