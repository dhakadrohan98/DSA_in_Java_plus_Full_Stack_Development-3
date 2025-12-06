package payu.string;

//Expand From Center Strategy algo is applied for palindrome check
//Trick- How to calculate coordinates of start & end pointer at i^th position in a string ?
public class LongestPalindromicSubstring {

	// TC: O(n)
	// SC: O(1)
	public String longestPalindrome(String s) {
		int n = s.length();
		int start = -1;
		int end = -1;
		for (int i = 0; i < n; i++) {
			int odd = expandFromCenter(s, i, i);
			int even = expandFromCenter(s, i, i + 1);
			int maxLen = Math.max(odd, even);
			if (end - start < maxLen) {
				start = i - ((maxLen - 1) / 2);
				end = i + (maxLen / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandFromCenter(String s, int i, int j) {
		int n = s.length();
		while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
