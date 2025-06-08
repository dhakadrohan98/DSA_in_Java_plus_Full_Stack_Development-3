package org.leetcodemedium.arr.revision2;

import java.util.*;
public class LongestSubarraySumEqualsK {
	
	//TC: O(n)
    //SC: O(n)
    public int longestSubarray(int[] nums, int k) {
        // code here
        Map<Integer, Integer> hmap = new HashMap<>();
		int n = nums.length;
		int prefixSum = 0, maxi = 0;
		for (int i = 0; i < n; i++) {
			prefixSum += nums[i];
			if(prefixSum == k) {
			    maxi = Math.max(maxi, i + 1);
			}
			else if (hmap.containsKey(prefixSum - k)) {
				int indx = hmap.get(prefixSum - k);
				maxi = Math.max(maxi, i - indx);
			}
			if(!hmap.containsKey(prefixSum)) {
			   hmap.put(prefixSum, i);   
			}
		}
		return maxi;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
