package payu.sliding.window;

import java.util.*;

public class LongestSubstringWithKUniqueCharacters {

	// TC: O(n)
	// SC: O(k)
	public int longestKSubstr(String s, int k) {
		// code here
		int n = s.length();
		Map<Character, Integer> hmap = new HashMap<>();
		// for(char ch : s.toCharArray()) {
		// hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		// }
		// int unique = hmap.size();
		int longest = -1;
		int i = 0, j = 0;
		while (j < n) {
			// some calculations
			char ch = s.charAt(j);
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
			if (hmap.size() < k) {
				j++;
			} else if (hmap.size() == k) {
				// calc ans
				longest = Math.max(longest, j - i + 1);
				j++;
			} else { // hmap.size() > k
				while (hmap.size() > k) {
					// remove calc for i
					char ch_i = s.charAt(i);
					if (hmap.containsKey(ch_i)) {
						hmap.put(ch_i, hmap.get(ch_i) - 1);
						if (hmap.get(ch_i) == 0) {
							hmap.remove(ch_i);
						}
					}
					// if hmap.size() == k then we can calculate ans again if it has been asked
					// that find the length of minimum substring which contains exactly K unique characters
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
