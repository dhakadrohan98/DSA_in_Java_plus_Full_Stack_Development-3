package org.codeship.slidingwindow.fixedsize.revision2;

import java.util.*;

public class CountOccurencesOfAnagrams {

	// TC: O(n)
	// SC: O(n)
	public int search(String pat, String txt) {
		// code here
		int n = txt.length();
		int k = pat.length();
		// Handle edge cases
		if (k == 0)
			return 0;
		if (k > n)
			return 0;
		Map<Character, Integer> hmap = new HashMap<>();
		for (char ch : pat.toCharArray()) {
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}
		int uniqueCount = hmap.size();
		int i = 0;
		int j = 0;
		int occurences = 0;
		while (j < n) {
			// do some calculations
			char ch = txt.charAt(j);
			if (hmap.containsKey(ch)) {
				hmap.put(ch, hmap.get(ch) - 1);
				if (hmap.get(ch) == 0) {
					uniqueCount--;
				}
			}
			// try to hit the window size
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// calculate ans
				if (uniqueCount == 0) {
					occurences += 1;
				}
				// remove calculation for i
				char ch1 = txt.charAt(i);
				if (hmap.containsKey(ch1)) {
					hmap.put(ch1, hmap.get(ch1) + 1);
					if (hmap.get(ch1) == 1) {
						uniqueCount += 1;
					}
				}
				// slide the window & maintain it
				i++;
				j++;
			}
		}
		return occurences;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
