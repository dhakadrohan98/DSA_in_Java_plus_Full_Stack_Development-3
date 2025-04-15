package org.codeship;

import java.util.Arrays;

public class Candy {

	// TC: O(3n)
	// SC: O(2n)
	public int candy(int[] arr) {
		int n = arr.length;
		int[] l2r = new int[n];
		int[] r2l = new int[n];
		// initially fill l2r and r2l arrays with 1
		Arrays.fill(l2r, 1);
		Arrays.fill(r2l, 1);
		// do calculaions from l2r
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				l2r[i] = Math.max(l2r[i], l2r[i - 1] + 1);
			}
		}
		// do calculaions from r2l
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				r2l[i] = Math.max(r2l[i], r2l[i + 1] + 1);
			}
		}

		int ans = 0;
		// calculate max(ans)
		for (int i = 0; i < n; i++) {
			ans += Math.max(l2r[i], r2l[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
