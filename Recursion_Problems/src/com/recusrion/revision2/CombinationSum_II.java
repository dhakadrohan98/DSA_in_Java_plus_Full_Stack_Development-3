package com.recusrion.revision2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {

	// TC: O(2^n) * k (copy elements from ds to arr)
	// SC: O(k * x) k -> average length of combination & x is the total number of
	// combinations
	public List<List<Integer>> combinationSum2(int[] arr, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		Arrays.sort(arr);
		helper(0, target, arr, ds, ans);
		return ans;
	}

	private void helper(int indx, int target, int[] arr, List<Integer> ds, List<List<Integer>> ans) {
		// base cases
		// target becomes equal to 0
		if (target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		if (indx < 0 || target < 0) {
			return;
		}

		// loop from indx to 0
		for (int i = indx; i < arr.length; i++) {
			if (i > indx && arr[i] == arr[i - 1]) {
				continue;
			}
			if (arr[i] > target)
				break;
			ds.add(arr[i]);
			helper(i + 1, target - arr[i], arr, ds, ans);
			ds.remove(ds.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
