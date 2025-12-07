package payu.sliding.window;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	// TC: O(n)
	// SC: O(1)
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Map<Character, Integer> hmap = new HashMap<>();
		int i = 0, j = 0;
		int longest = 0;
		while (j < n) {
			char ch_j = s.charAt(j);
			// do some calculations
			hmap.put(ch_j, hmap.getOrDefault(ch_j, 0) + 1);
			if (hmap.get(ch_j) == 1) {
				longest = Math.max(longest, j - i + 1);
				j++;
			} else if (hmap.get(ch_j) > 1) { // found some repeating characters in substring
				// remove calculation for i
				while (hmap.get(ch_j) > 1) {
					char ch_i = s.charAt(i);
					hmap.put(ch_i, hmap.get(ch_i) - 1);
					i++;
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
