package payu.string;

public class StringToInteger_Atoi_EdgeCasesHeavy {

	// TC: O(n)
	// SC: O(1)
	public int myAtoi(String s) {
		// remove any leading or trailing whitespaces
		s = s.trim();
		// edge case for empty string after removing whitespaces
		if (s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int i = 0;
		boolean isNeg = false;
		long res = 0;
		while (i < n) {
			char ch = s.charAt(i);
			if (i == 0 && ch == '-') {
				isNeg = true;
				i++;
				continue;
			} else if (i == 0 && ch == '+') {
				i++;
				continue;
			}
			// from i=1
			// no need to skip leading zeroes
			if (ch >= '0' && ch <= '9') {
				res = (res * 10) + (ch - '0');
				if (isNeg) {
					long checkNegRes = -res;
					if (checkNegRes < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				} else {
					if (res > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				}
			} else {
				// if character is non digit character
				break;
			}
			i++;
		}

		if (isNeg) {
			res = res * -1l;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
