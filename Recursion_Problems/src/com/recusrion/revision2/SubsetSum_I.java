package com.recusrion.revision2;

import java.util.ArrayList;

public class SubsetSum_I {

	// TC: O(2^n)
	// SC: O(n) recursion stack space
	public ArrayList<Integer> subsetSums(int[] arr) {
		// code here
		int n = arr.length;
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> ds = new ArrayList<>();
		int sum = 0;
		rec(sum, n - 1, arr, ds, ans);
		return ans;
	}

	private void rec(int sum, int indx, int[] arr, ArrayList<Integer> ds, ArrayList<Integer> ans) {
		// base case
		if (indx < 0) {
			ans.add(sum);
			return;
		}

		// pick the curr element
		rec(sum + arr[indx], indx - 1, arr, ds, ans);
		// do not pick the current element
		rec(sum, indx - 1, arr, ds, ans);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
