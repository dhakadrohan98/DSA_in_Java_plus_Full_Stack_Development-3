package com.codeship.medium.revision3;

import java.util.*;

public class LongestConsecutiveSequence {
	
	//TC: O(2n)
	//SC: O(n)
	public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        
        for(int num: nums) {
        	set.add(num);
        }

        for(int num : nums) {
            if(set.contains(num-1)) { //not first element of any sequence
                continue;
            } else {
            	int temp = num;
                int count = 1;
                while(set.contains(temp+1)) {
                    count += 1;
                    temp += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
		System.out.println(longestConsecutive(nums));
	}

}
