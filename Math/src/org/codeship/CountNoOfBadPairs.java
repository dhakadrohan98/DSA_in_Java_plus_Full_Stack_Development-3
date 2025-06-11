package org.codeship;

import java.util.*;
public class CountNoOfBadPairs {
	
	//TC: O(n)
    //SC: O(n)
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        Map<Long, Long> hmap = new HashMap<>();
        long totalPairs = n * (n-1)/2;
        long goodPairs = 0l;
        for(int i = 0; i < n; i++) {
            long val = i - nums[i];
            long count = hmap.getOrDefault(val, 0l);
            goodPairs += count;
            hmap.put(val, hmap.getOrDefault(val, 0l) + 1l);
        }
        return totalPairs - goodPairs;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
