package com.codeship.easy.revision;

import java.util.*;

public class TwoSum {
	
	//TC: O(n)
    //SC: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int size = nums.length;
        for(int i = 0; i < size; i++) {
            int remaining = target - nums[i];
            if(map.containsKey(remaining)) {
                result[0] = i;
                result[1] = map.get(remaining);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
