package com.recursion.revision3;

import java.util.*;

public class CombinationSum {

	// TC: O(m^n) where m is maximum elements of array at a particular index can be part of combinations
	// SC: O(m)
	public List<List<Integer>> combinationSum(int[] arr, int target) {
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		rec(n - 1, target, arr, list, ans);
		return ans;
	}

	private void rec(int i, int target, int[] arr, List<Integer> list, List<List<Integer>> ans) {
		// base case
		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}
		// didn't find the combinations yet & ran out of array elements
		if (i < 0) {
			return;
		}

		if (arr[i] <= target) {
			list.add(arr[i]);
			rec(i, target - arr[i], arr, list, ans);
			// backtrack step undo- remove the last element from list which were added in
			// line 16
			list.remove(list.size() - 1);
		}
		rec(i - 1, target, arr, list, ans);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
