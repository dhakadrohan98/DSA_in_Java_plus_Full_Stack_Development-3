package com.four.medium.revision;

public class NextPermutations {

	// TC: O(2n)
	// SC: O(1)
	public static void nextPermutation(int[] nums) {
		int indx = -1;
		int len = nums.length;
		// find the break point
		for (int i = len - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				indx = i;
				break;
			}
		}
		// if no break point is present, it means given combination is the largest
		// number among n numbers.
		// In such case, reverse the array(smallest one)
		if (indx == -1) {
			rev(nums, 0, len - 1);
			return;
		}

		// find the element just greater than break point element, if found the swap it
		// with break point element
		for (int i = len - 1; i >= indx; i--) {
			if (nums[i] > nums[indx]) {
				swap(nums, indx, i);
				break;
			}
		}
		// reverse the array
		rev(nums, indx + 1, len - 1);
	}

	private static void rev(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 4, 3, 0, 0 };
		int[] nums2 = { 5, 4, 3, 2, 1 };
		nextPermutation(nums2);
		for (int num : nums2) {
			System.out.print(num + " ");
		}
	}

}
