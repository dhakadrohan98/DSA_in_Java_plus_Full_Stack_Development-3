package com.recursion.revision3;

import java.util.*;

public class Permutations {

	//TC: O(2^n)
	//SC: O(n)
	public List<List<Integer>> permute(int[] nums) {
		int n = nums.length;
		boolean[] visited = new boolean[n];
		List<Integer> ds = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		rec(nums, visited, ds, ans);
		return ans;
	}

	private void rec(int[] nums, boolean[] visited, List<Integer> ds, List<List<Integer>> ans) {
		// base case
		if (ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// if current element is not visited then add it into ds & mark it as visit
			if (!visited[i]) {
				ds.add(nums[i]);
				visited[i] = true;
				rec(nums, visited, ds, ans);
				// backtrack step- undo the changes
				ds.remove(ds.size() - 1);
				visited[i] = false;
			}
		}
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
