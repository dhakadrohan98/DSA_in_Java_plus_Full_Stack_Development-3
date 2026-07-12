package org.codeship.slidingwindow.fixedsize.revision3;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencesOfAnagram {

	// TC: O(m+n) | m = len of txt, n = len of pat
	// SC: O(n)
	public static int search(String txt, String pat) {
		// code here
		int n = txt.length();
		int ans = 0;
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		for (char ch : pat.toCharArray()) {
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}
		int k = pat.length();
		int i = 0, j = 0;
		int uniqueCount = hmap.size();

		while (j < n) {
			// do some calculations
			char ch = txt.charAt(j);
			if (hmap.containsKey(ch)) {
				hmap.put(ch, hmap.get(ch) - 1);
				if (hmap.get(ch) == 0) {
					uniqueCount -= 1;
				}
			}

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// calculate ans
				if (uniqueCount == 0) { // we have all characters of pat in our window
					ans += 1;
				}
				// remove calculations for i
				char ch1 = txt.charAt(i);
				if (hmap.containsKey(ch1)) {
					hmap.put(ch1, hmap.get(ch1) + 1);
					if (hmap.get(ch1) == 1) {
						uniqueCount += 1;
					}
				}
				// slide the window - maintain the window size, So calculation for new Jth character can be performed in next iteration
				i++;
				j++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String txt = "forxxorfxdofr";
		String pat = "for";
		System.out.println(search(txt, pat));

	}

}
