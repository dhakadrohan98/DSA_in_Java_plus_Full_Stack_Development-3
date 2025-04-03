package org.codeship.binarysearch.revision;

public class SquareRootOfNumber {

	// TC: O(logx)
	// SC: O(1)
	public int mySqrt(int x) {
		long low = 1;
		long high = x;
		long ans = 0;
		// edge cases
		if (x == 1 || x == 0) {
			return x;
		}
		while (low < high) {
			long mid = (low + high) / 2;
			if (mid * mid <= x) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return (int) ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
