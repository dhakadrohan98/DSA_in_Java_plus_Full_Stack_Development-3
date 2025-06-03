package org.leetcodemedium.arr.revision2;

import java.util.*;;
public class LongestConsecutiveSequence {
	
	 //TC: O(2*n)
    //SC: O(n)
    public int longestConsecutive(int[] nums) {
        int n =  nums.length;
        //edge case
        if(n == 0 || n == 1) {
            return n;
        }
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int num: nums) {
            set.add(num);
        }
        for(int itr:set) {
            if(!set.contains(itr-1)) {
                int temp = itr;
                int count = 1;
                while(set.contains(temp+1)) {
                    count++;
                    temp += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
