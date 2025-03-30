package org.leetcodemedium.arr.revision;

public class MergeSortedArray {

	// TC: O(m+n)
	// SC: O(1)
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i--];
			} else if (nums1[i] <= nums2[j]) {
				nums1[k] = nums2[j--];
			}
			k--;
		}
		// If some elements in nums2 array are remaining due to lower value than nums1
		// array elements
		// then copy remaining elements from nums2 as it is in nums1 from a pointer k.
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
