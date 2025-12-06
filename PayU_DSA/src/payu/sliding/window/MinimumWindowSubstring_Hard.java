package payu.sliding.window;

import java.util.*;

public class MinimumWindowSubstring_Hard {

	// TC: O(m+n)
	// SC: O(m)
	public String minWindow(String s, String t) {
		int n = s.length();
		int start = -1;
		int end = -1;
		// Map<Character, Integer> hmap = new HashMap<>();
		int tLen = t.length();
		Map<Character, Integer> hmap1 = new HashMap<>();
		for (int i = 0; i < tLen; i++) {
			char ch = t.charAt(i);
			hmap1.put(ch, hmap1.getOrDefault(ch, 0) + 1);
		}
		// unique char count
		int k = hmap1.size();
		int i = 0, j = 0;
		int minSize = Integer.MAX_VALUE;
		while (j < n) {
			// do some calculation
			char ch_j = s.charAt(j);
			// hmap.put(ch_j, hmap.getOrDefault(ch_j, 0) + 1);
			if (hmap1.containsKey(ch_j)) {
				hmap1.put(ch_j, hmap1.get(ch_j) - 1);
				if (hmap1.get(ch_j) == 0) {
					k--;
				}
			}
			if (k > 0) { // try to hit the correct window
				j++;
			} else if (k == 0) {
				while (k == 0) {
					// calculate one ans
					if (j - i + 1 < minSize) {
						start = i;
						end = j;
						minSize = Math.min(minSize, j - i + 1);
					}
					// reduce calculations for ith element from hmap1
					char ch_i = s.charAt(i);
					if (hmap1.containsKey(ch_i)) {
						hmap1.put(ch_i, hmap1.get(ch_i) + 1);
						if (hmap1.get(ch_i) == 1) {
							k++;
						}
					}
					i++;
				}
				j++;
			}
		}
		if (start != -1 && end != -1) {
			return s.substring(start, end + 1);
		}
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
