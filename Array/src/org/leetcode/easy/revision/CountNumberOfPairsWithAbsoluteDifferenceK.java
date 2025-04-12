package org.leetcode.easy.revision;

import java.util.*;
public class CountNumberOfPairsWithAbsoluteDifferenceK {
	
	//TC: O(n)
    //SC: O(n)
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < n; i++) {
            // [3,2,1,5,4], k = 2
            // check nums[i] + k in map
            //check nums[i] -  k also in the map
            if(hmap.containsKey(nums[i] + k)) {
                pairs += hmap.get(nums[i] + k);
            }
            if(hmap.containsKey(nums[i] - k)) {
                pairs += hmap.get(nums[i] - k);
            }
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        return pairs;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
