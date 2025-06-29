package com.recusrion.revision2;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPermutationOfArray {

	// TC: O(n! - total no. of permutations * n - loop)
	// SC: O(n) due to ds + O(n) - visited array
	public List<List<Integer>> permute(int[] nums) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean[] freq = new boolean[n];
		rec(nums, freq, ds, ans);
		return ans;
	}

	private void rec(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> ans) {
		// base case
		if (ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
		}

		// loop from 0 to n-1
		for (int i = 0; i < nums.length; i++) {
			if (!freq[i]) {
				ds.add(nums[i]);
				freq[i] = true;
				rec(nums, freq, ds, ans);
				// backtrack steps
				ds.remove(ds.size() - 1);
				freq[i] = false;
				;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
