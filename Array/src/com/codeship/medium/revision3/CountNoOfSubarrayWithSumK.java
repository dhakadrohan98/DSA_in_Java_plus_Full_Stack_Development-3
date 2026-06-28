package com.codeship.medium.revision3;

import java.util.Map;
import java.util.HashMap;
;
public class CountNoOfSubarrayWithSumK {
	
	//TC: O(n)
	//SC: O(n)
	public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        hmap.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if(hmap.containsKey(prefixSum - k)) {
                count += hmap.get(prefixSum - k);
            }
            hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
