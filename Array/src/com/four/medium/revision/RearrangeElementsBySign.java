package com.four.medium.revision;

public class RearrangeElementsBySign {

	// TC: O(2n)
	// SC: O(n+(n/2))
	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;
		int[] negArr = new int[n / 2];
		int[] result = new int[n];
		int ptr = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0 && ptr < n / 2) {
				negArr[ptr] = nums[i];
				nums[i] = 0;
				ptr++;
			}
		}

		boolean postiveFlag = true;
		int i = 0; // can go upto n (for +ve arr)
		int j = 0; // can go upto n/2 only (for -ve arr)
		int k = 0; // can go upto n (for resultant array)
		while (k < n) {
			if (postiveFlag && i < n) {
				if (nums[i] != 0) {
					result[k++] = nums[i++];
					postiveFlag = !postiveFlag;
				} else {
					i++;
				}
			} else if (!postiveFlag && j < n / 2) {
				result[k++] = negArr[j++];
				postiveFlag = !postiveFlag;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
