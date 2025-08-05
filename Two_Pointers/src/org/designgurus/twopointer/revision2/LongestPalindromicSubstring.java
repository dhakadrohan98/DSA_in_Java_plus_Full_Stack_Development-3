package org.designgurus.twopointer.revision2;

public class LongestPalindromicSubstring {

	// TC: O(n*k) where k is the average length of palindromic substring
	// SC: O(1)
	public String longestPalindrome(String s) {
		int n = s.length();
		int start = -1;
		int end = -1;
		int mid = n / 2;
		for (int i = 0; i < n; i++) {
			int oddLen = expandFromCenter(i, i, s);
			int evenLen = expandFromCenter(i, i + 1, s);
			int maxLen = Math.max(oddLen, evenLen);
			if (end - start < maxLen) {
				start = i - (maxLen - 1) / 2;
				end = i + (maxLen / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandFromCenter(int i, int j, String s) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
