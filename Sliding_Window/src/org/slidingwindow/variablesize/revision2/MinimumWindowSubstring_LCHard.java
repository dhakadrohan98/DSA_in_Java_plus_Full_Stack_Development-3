package org.slidingwindow.variablesize.revision2;

import java.util.*;

public class MinimumWindowSubstring_LCHard {
	//All 268 test cases are passed
	// TC: O(n)
	// SC: O(n)
	public String minWindow(String s, String t) {
		int m = s.length();
		int n = t.length();
		int i = 0, j = 0;
		Map<Character, Integer> hmap = new HashMap<>();
		for (char ch1 : t.toCharArray()) {
			hmap.put(ch1, hmap.getOrDefault(ch1, 0) + 1);
		}
		int unique = hmap.size();
		int mini = Integer.MAX_VALUE;
		int start = -1, end = -1;

		while (j < m) {
			char ch = s.charAt(j);
			// do some calculations
			if (hmap.containsKey(ch)) {
				hmap.put(ch, hmap.get(ch) - 1);
				if (hmap.get(ch) == 0) {
					unique -= 1;
				}
			}
			// condition is met, calculate the answer
			if (unique == 0) {
				// if answer is still valid, then shrink the window from left side
				// until unique character count is 0
				while (unique == 0) {
					if (mini > j - i + 1) {
						start = i;
						end = j;
						mini = j-i+1;
					}
					char ch1 = s.charAt(i);
					if (hmap.containsKey(ch1)) {
						hmap.put(ch1, hmap.get(ch1) + 1);
						if (hmap.get(ch1) == 1) {
							unique += 1;
						}
					}
					i++;
				}
			}
			j++;
		}
		if (start == -1 && end == -1) {
			return "";
		}
		return s.substring(start, end + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
