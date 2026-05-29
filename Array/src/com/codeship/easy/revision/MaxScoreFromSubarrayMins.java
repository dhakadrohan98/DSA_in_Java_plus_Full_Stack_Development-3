package com.codeship.easy.revision;

public class MaxScoreFromSubarrayMins {
	
	//TC: O(n)
	//SC: O(1)
	public int maxSum(int arr[]) {
		// code here
		int n = arr.length;
		int maxi = 0;
		for (int i = 1; i < n; i++) {
			int sum = arr[i - 1] + arr[i];
			maxi = Math.max(maxi, sum);
		}

		return maxi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
