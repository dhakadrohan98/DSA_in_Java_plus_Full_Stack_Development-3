package org.string.leetcode.mediumProblems.revision3;

public class SumOfBeautyOfAllSubstring {

	// TC: O(n^2 * 52)
	// SC: O(52)
	private int maxFreq(char ch, int[] freq) {
		int maxi = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				maxi = Math.max(maxi, freq[i]);
			}
		}
		return maxi;
	}

	private int minFreq(char ch, int[] freq) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				min = Math.min(min, freq[i]);
			}
		}
		return min;
	}

	public int beautySum(String s) {
		int n = s.length();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			// creating new freq array for each starting substring (i=0,1,2,...,n-1)
			int[] freq = new int[26];
			for (int j = i; j < n; j++) {
				char ch = s.charAt(j);
				freq[ch - 'a']++;
				// How to update max & min - Sol use frequency array instead of hashmap approach
				int maxi = maxFreq(ch, freq);
				int min = minFreq(ch, freq);
				sum += (maxi - min);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		SumOfBeautyOfAllSubstring obj = new SumOfBeautyOfAllSubstring();
		String s1 = "aabcbaa";
		System.out.println(obj.beautySum(s1));

	}

}
