package org.codeship.binarysearch.revision;

public class MedianOfTwoSortedArray {

	// TC: O(log min(n1, n2))
	// SC: O(1)
	public double findMedianSortedArrays(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		if (n1 > n2) {
			return findMedianSortedArrays(arr2, arr1);
		}
		int low = 0, high = n1;
		int leftSide = (n1 + n2 + 1) / 2;
		int totalElements = n1 + n2;

		while (low <= high) {
			int mid1 = (low + high) / 2;
			int mid2 = leftSide - mid1;
			// initialization for l1, l2, r1 & r2
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			// mid1 might go index of out of bound, check the boundary condition
			if (mid1 < n1)
				r1 = arr1[mid1];
			if (mid2 < n2)
				r2 = arr2[mid2];
			if (mid1 - 1 >= 0) {
				l1 = arr1[mid1 - 1];
			}
			if (mid2 - 1 >= 0) {
				l2 = arr2[mid2 - 1];
			}
			// only one ans is possible
			if (l1 <= r2 && l2 <= r1) {
				// if n1 + n2 is odd
				if (totalElements % 2 != 0) {
					return (double) Math.max(l1, l2);
				}
				double median = (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
				return median;
			} else if (l1 > r2) {
				high = mid1 - 1;
			} else {
				low = mid1 + 1;
			}
		}
		// dummy return 0.0
		return 0.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
