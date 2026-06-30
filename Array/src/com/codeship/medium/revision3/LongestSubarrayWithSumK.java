package com.codeship.medium.revision3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

	// TC: O(n)
	// SC: O(n)
	// prefix sum + HahsMap
	public int longestSubarray(int[] arr, int k) {
		// code here
		Map<Integer, Integer> hmap = new HashMap<>();
		int ps = 0;
		int longest = 0;

		hmap.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			ps += arr[i];
			if (hmap.containsKey(ps - k)) {
				int secondIndx = hmap.get(ps - k);
				int diffLength = i - secondIndx;
				longest = Math.max(longest, diffLength);
			}
			if (!hmap.containsKey(ps)) {
				hmap.put(ps, i);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
