package com.recusrion.revision;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	// TC: O(n! * n(due to for loop at level))
	// SC: O(2*n) map space + stack recursion space
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		int n = nums.length;
		boolean[] map = new boolean[n];
		rec(nums, map, ds, ans);
		return ans;
	}

	private void rec(int[] arr, boolean[] map, List<Integer> ds, List<List<Integer>> ans) {
		// base case
		if (ds.size() == arr.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// index never used for current permutation
			if (!map[i]) {
				ds.add(arr[i]);
				map[i] = true;
				rec(arr, map, ds, ans);
				// while backtrack undo the added element & unmark the index in map
				ds.remove(ds.size() - 1);
				map[i] = false;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
