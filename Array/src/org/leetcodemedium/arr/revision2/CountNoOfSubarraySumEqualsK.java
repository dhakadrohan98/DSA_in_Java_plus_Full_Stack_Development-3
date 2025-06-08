package org.leetcodemedium.arr.revision2;

import java.util.*;

public class CountNoOfSubarraySumEqualsK {

	// TC: O(n)
	// SC: O(n)
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int n = nums.length;
		int prefixSum = 0, count = 0;
		hmap.put(0, 1);
		for (int i = 0; i < n; i++) {
			prefixSum += nums[i];
			if (hmap.containsKey(prefixSum - k)) {
				count += hmap.get(prefixSum - k);
			}
			hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
