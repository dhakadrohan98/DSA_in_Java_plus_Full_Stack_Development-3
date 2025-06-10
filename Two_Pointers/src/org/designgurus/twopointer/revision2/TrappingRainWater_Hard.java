package org.designgurus.twopointer.revision2;

public class TrappingRainWater_Hard {

	// TC: O(3n)
	// SC: O(2n)
	// Concept - build maxLeft & maxRight element to know at max how much water can
	// be trapped at given bulding height
	public int trap(int[] arr) {
		int n = arr.length;
		int ans = 0;
		int[] maxLeft = new int[n];
		int maxi = arr[0];
		maxLeft[0] = maxi;
		for (int i = 1; i < n; i++) {
			maxi = Math.max(maxi, arr[i]);
			maxLeft[i] = maxi;
		}
		int[] maxRight = new int[n];
		maxi = arr[n - 1];
		maxRight[n - 1] = maxi;
		for (int i = n - 2; i >= 0; i--) {
			maxi = Math.max(maxi, arr[i]);
			maxRight[i] = maxi;
		}
		for (int i = 0; i < n; i++) {
			int min = Math.min(maxLeft[i], maxRight[i]);
			int water = min - arr[i];
			ans += water;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
