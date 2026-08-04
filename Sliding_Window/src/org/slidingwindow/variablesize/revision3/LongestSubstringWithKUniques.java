package org.slidingwindow.variablesize.revision3;

import java.util.*;

public class LongestSubstringWithKUniques {

	// TC: O(n)
	// SC: O(n)

	public static int longestKSubstr(String s, int k) {
		// code here
		Map<Character, Integer> hmap = new HashMap<>();
		int longest = 0;
		int i = 0, j = 0;
		while (j < s.length()) {
			// do some calc..
			char ch = s.charAt(j);
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
			// behing the condition
			if (hmap.size() < k) {
				j++;
			} else if (hmap.size() == k) {
				// calculate ans
				longest = Math.max(longest, j - i + 1);
				j++;
			} else if (hmap.size() > k) {
				while (hmap.size() > k) {
					char ch1 = s.charAt(i);
					hmap.put(ch1, hmap.get(ch1) - 1);
					if (hmap.get(ch1) == 0) {
						hmap.remove(ch1);
					}
					i++;
				}
				// calculate ans because we have hit the condition again
				longest = Math.max(longest, j - i + 1);
				j++;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabacbebebe";
		int k = 3;
		System.out.println(longestKSubstr(str, k));

	}

}
