package org.leetcodemedium.arr.revision2;

public class SortColors_NationalDutchFlagProblem {

	// TC: O(n)
	// SC: O(1) in place - without extra space
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void sortColors(int[] nums) {
		int n = nums.length;
		int start = 0, mid = 0, end = n - 1;
		while (mid <= end) {
			if (nums[mid] == 0) {
				swap(nums, start, mid);
				start++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				// nums[mid] == 2
				swap(nums, mid, end);
				end--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
