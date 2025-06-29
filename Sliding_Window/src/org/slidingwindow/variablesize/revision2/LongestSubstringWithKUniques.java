package org.slidingwindow.variablesize.revision2;

import java.util.*;

public class LongestSubstringWithKUniques {

	// TC: O(n)
	// SC: O(n)
	public int longestkSubstr(String s, int k) {
		// code here
		int n = s.length();
		Map<Character, Integer> hmap = new HashMap<>();
		int i = 0, j = 0;
		int longest = -1;
		while (j < n) {
			char ch = s.charAt(j);
			// do some calculations
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
			// condition is not met yet
			if (hmap.size() < k) {
				j++;
			} else if (hmap.size() == k) {
				// calculations for ans
				longest = Math.max(longest, j - i + 1);
				j++;
			} else { // hmap.size() > k
				// remove calculations for i(from left side)
				while (hmap.size() > k) {
					char ch1 = s.charAt(i);
					hmap.put(ch1, hmap.get(ch1) - 1);
					if (hmap.get(ch1) == 0) {
						hmap.remove(ch1);
					}
					i++;
				}
				// Again check for ans
				if (hmap.size() == k) {
					longest = Math.max(longest, j - i + 1);
				}
				j++;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
