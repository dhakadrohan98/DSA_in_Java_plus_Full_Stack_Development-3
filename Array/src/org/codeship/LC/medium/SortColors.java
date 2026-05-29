package org.codeship.LC.medium;

public class SortColors {

	// TC: O(n)
	// SC: O(1) in place sorting (0s,1s,2s)
	public void sortColors(int[] nums) {
		int len = nums.length;
		int start = 0;
		int mid = 0;
		int end = len - 1;

		// edge cases handling
		if (len == 1) {
			return;
		}
		if (len == 2) {
			if (nums[start] > nums[end]) {
				swap(nums, start, end);
			}
			return;
		}

		while (start <= mid && mid <= end) {
			// case0
			if (nums[mid] == 0) {
				swap(nums, start, mid);
				start += 1;
				mid += 1;
			}
			// case 1
			else if (nums[mid] == 1) {
				// no swapping
				mid += 1;
			}
			// case2
			else if (nums[mid] == 2) {
				swap(nums, mid, end);
				end--;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
