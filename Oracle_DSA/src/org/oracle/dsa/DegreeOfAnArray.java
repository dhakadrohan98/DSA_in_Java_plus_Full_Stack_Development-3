package org.oracle.dsa;

import java.util.*;

public class DegreeOfAnArray {

	//TC: O(3*n)
    //SC: O(2*n)
    public int findShortestSubArray(int[] nums) {
       int n = nums.length;
       //edge case
       if(n == 1) {
        return 1;
       }
        Map<Integer, Integer> hmap1 = new HashMap<>();
        Map<Integer, List<Integer>> hmap2 = new HashMap<>();
        int max = 0;

        for(int num : nums) {
            hmap1.put(num, hmap1.getOrDefault(num, 0) + 1);
            max = Math.max(max, hmap1.get(num));
        }
        
        for(int i = 0; i < n; i++) {
        	int val = hmap1.get(nums[i]);
        	if(val == max) {
        		List<Integer> list = null;
        		if(!hmap2.containsKey(nums[i])) {
        			list = new ArrayList<>();
        			list.add(i);
        		} else {
        			list = hmap2.get(nums[i]);
        			if(list.size() >= 2) {
        				list.remove(1);
        			}
        			list.add(i);
        		}
        		hmap2.put(nums[i], list);
        	}
        }
        int shortestSubArraylength = Integer.MAX_VALUE;
        //iterate over keys of hmap2
        for(Map.Entry<Integer, List<Integer>> temp: hmap2.entrySet()) {
        	int key = temp.getKey();
        	List<Integer> list = temp.getValue();
            if(list.size() == 2) {
                shortestSubArraylength = Math.min(list.get(1) - list.get(0) + 1, shortestSubArraylength);
            } else {
                shortestSubArraylength = Math.min(1, shortestSubArraylength);
            }
        	
        }
        return shortestSubArraylength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
