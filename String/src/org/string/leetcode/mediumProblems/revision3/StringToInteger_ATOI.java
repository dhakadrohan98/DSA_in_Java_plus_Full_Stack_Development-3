package org.string.leetcode.mediumProblems.revision3;

//code passed 1096 test cases
public class StringToInteger_ATOI {

	public static int myAtoi(String s) {
		s = s.trim();
		int n = s.length();
		// edge case
		if (n == 0) {
			return 0;
		}
		long num = 0l;
		boolean isNeg = false;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (i == 0) {
				// check sign
				if (ch == '-') {
					isNeg = true;
					continue;
				} else if (ch == '+') {
					continue;
				}
			}
			if (ch >= '0' && ch <= '9') {
				num = (num * 10) + (ch - '0');
				System.out.print(num + " ");
			} else { // encountered non digit character
//				System.out.println(ch);
				break;
			}
			if (num < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			if (num > Integer.MAX_VALUE) {
				if (isNeg) {
					return (Integer.MAX_VALUE * -1) - 1;
				}
				return Integer.MAX_VALUE;
			}
		}

		if (isNeg) {
			num = num * -1;
		}
		return (int) num;
	}

	public static void main(String[] args) {
		String str = "-91283472332";
		System.out.println(myAtoi(str));

	}

}
