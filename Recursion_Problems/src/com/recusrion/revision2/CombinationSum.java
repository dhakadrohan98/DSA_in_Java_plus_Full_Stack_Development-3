package com.recusrion.revision2;

import java.util.*;

public class CombinationSum {

	// TC: O(2^n) uncertain because any number of elements are valid candidate to
	// sum up to the target
	// SC: O(n) stack space is also uncertain
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		rec(nums, n - 1, 0, target, ds, ans);
		return ans;
	}

	private void rec(int[] nums, int indx, int sum, int target, List<Integer> ds, List<List<Integer>> ans) {
		// base cases
		if (sum == target) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		if (sum > target) {
			return;
		}
		if (indx < 0) {
			return;
		}

		// go to the same index
		if (sum <= target) {
			ds.add(nums[indx]);
			rec(nums, indx, sum + nums[indx], target, ds, ans);
			ds.remove(ds.size() - 1);
		}
		// go to next index
		rec(nums, indx - 1, sum, target, ds, ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
