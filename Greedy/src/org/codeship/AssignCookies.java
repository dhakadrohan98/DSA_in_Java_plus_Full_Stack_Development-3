package org.codeship;

import java.util.Arrays;

public class AssignCookies {

	// TC: O(nlogn) due to dual pivot quick sort
	// SC: O(logn)
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g); // Sort greed factors
		Arrays.sort(s); // Sort cookie sizes

		int l = 0; // Pointer for children (s)
		int r = 0; // Pointer for greed (g)

		while (r < g.length && l < s.length) {
			if (g[r] <= s[l]) {
				// Cookie j satisfies child i
				r++;
			}
			// Always move to next cookie
			l++;
		}

		return r; // Number of content children
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
