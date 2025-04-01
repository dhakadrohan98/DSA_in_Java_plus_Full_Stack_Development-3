package org.codeship.binarysearch.revision;

public class CountOccurencesInArray_logn {

	// TC: O(2logn)
	// SC: O(1)
	private int findStarting(int[] nums, int n, int target) {
		int low = 0, high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				ans = mid;
				// find left most side element
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	private int findEnding(int[] nums, int n, int target) {
		int low = 0, high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				ans = mid;
				// find right most side element
				low = mid + 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public int countFreq(int[] nums, int target) {
		int n = nums.length;
		int startingIndx = findStarting(nums, n, target);
		int endIndx = findEnding(nums, n, target);
		// element is not found
		if (startingIndx == -1 & endIndx == -1) {
			return 0;
		}
		return endIndx - startingIndx + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
