package org.string.leetcode.mediumProblems.revision2;

public class StringToInteger_Atoi {

	// TC: O(n)
	// SC: O(1)
	public int myAtoi(String s) {
		s = s.trim();
		int len = s.length();
		long ans = 0;
		boolean neg = false;
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (i == 0) {
				if (ch == '-') {
					neg = true;
					continue;
				} else if (ch == '+') {
					continue;
				}
			}
			if (ch >= '0' && ch <= '9') {
				ans = ans * 10 + (ch - '0');
				if (neg) {
					if (-ans < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				} else { // neg = false
					if (ans > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				}
			} else {
				break;
			}
		}

		if (neg) {
			ans = -ans;
		}
		return (int) ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
