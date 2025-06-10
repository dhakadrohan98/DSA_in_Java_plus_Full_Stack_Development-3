package org.designgurus.twopointer.revision2;

import java.util.*;

public class _3Sum {
	
	 //TC: O(n^2) + O(nlogn) Quick sort dual pivot
    //SC: O(logn)
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int target = 0;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < n-2) {
            int j = i + 1;
            int k = n - 1; 
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target) {
                    j++;
                } else if(sum > target){
                    k--;
                } else {
                    //sum == target
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    set.add(list);
                    j++;
                    k--;
                }
            }
            i += 1;
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
