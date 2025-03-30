package org.leetcodemedium.arr.revision;

import java.util.*;
public class MajorityElement_II {
	
	//TC: O(n)
    //SC: O(n)
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int num: nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        for(int key: hmap.keySet()) {
            int val = hmap.get(key);
            if(val > (n / 3)) {
                list.add(key);
            }
        }
        return list;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
