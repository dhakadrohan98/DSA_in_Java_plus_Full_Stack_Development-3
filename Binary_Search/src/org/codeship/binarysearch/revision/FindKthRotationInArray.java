package org.codeship.binarysearch.revision;

import java.util.List;

public class FindKthRotationInArray {

	// TC: O(logn)
	// SC: O(1)
	public int findKRotation(List<Integer> arr) {
		// Code here
		int n = arr.size();
		int low = 0, high = n - 1;
		int ans = Integer.MAX_VALUE;
		int index = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr.get(low) <= arr.get(mid)) {
				// left half is sorted
				// pick the minimum & eliminate the left half search space
				if (arr.get(low) < ans) {
					ans = arr.get(low);
					index = low;
				}
				low = mid + 1;
			} else if (arr.get(mid) <= arr.get(high)) {
				// right half is sorted
				// pick the minimum & eliminate the right half search space
				if (arr.get(mid) < ans) {
					ans = arr.get(mid);
					index = mid;
				}
				high = mid - 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
