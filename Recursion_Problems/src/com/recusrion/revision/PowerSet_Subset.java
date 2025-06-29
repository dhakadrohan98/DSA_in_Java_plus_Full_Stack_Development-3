package com.recusrion.revision;

import java.util.*;

public class PowerSet_Subset {

	// TC: O(2^n) include & not include concept
	// SC: O(n) stack space
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		rec(0, nums, ds, ans);
		return ans;
	}

	private void rec(int indx, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
		// base case
		if (indx >= nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		// include current element
		ds.add(nums[indx]);
		rec(indx + 1, nums, ds, ans);
		// backtrack, remove the previous added element
		ds.remove(ds.size() - 1);
		rec(indx + 1, nums, ds, ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
