package org.codeship.binarysearch.revision;

public class CapacityToShipPackagesWithinDDays {

	// TC: O(log (sum - max + 1) * n)
	// SC: O(1)
	private int findDays(int[] arr, int capacity) {
		int days = 1;
		int load = 0;
		for (int num : arr) {
			if (load + num > capacity) {
				days += 1;
				load = num;
			} else {
				load += num;
			}
		}
		return days;
	}

	public int shipWithinDays(int[] arr, int days) {
		int max = 0;
		int sum = 0;
		int ans = 0;
		// find the max no. from arr as min_capacity
		// find the sum of all weights as max_capacity
		for (int num : arr) {
			max = Math.max(max, num);
			sum += num;
		}
		int low = max, high = sum;
		while (low <= high) {
			int mid = (low + high) / 2;
			int requiredDays = findDays(arr, mid);
			if (requiredDays <= days) {
				// we required least days hence trim down the right half search space
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
