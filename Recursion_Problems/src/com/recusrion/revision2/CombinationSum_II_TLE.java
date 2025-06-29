package com.recusrion.revision2;

import java.util.*;

public class CombinationSum_II_TLE {

	// TLE - 171 out of 176 test cases are passed
	// TC: O(n * logn) + O(2^n * k)
	// SC: O(logn + n)
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		int n = nums.length;
		int indx = n - 1;
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> ds = new ArrayList<>();
		Arrays.sort(nums);
		rec(indx, target, nums, ds, set);
		// convert set into list
		List<List<Integer>> ans = new ArrayList<>(set);
		return ans;
	}

	private void rec(int indx, int target, int[] nums, List<Integer> ds, Set<List<Integer>> set) {
		// base case
		if (target == 0) {
			set.add(new ArrayList<>(ds));
			return;
		}
		if (target < 0 || indx < 0) {
			return;
		}

		// include curr element in ds
		ds.add(nums[indx]);
		rec(indx - 1, target - nums[indx], nums, ds, set);
		// backtrack remove the last element from set
		ds.remove(ds.size() - 1);
		rec(indx - 1, target, nums, ds, set);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
