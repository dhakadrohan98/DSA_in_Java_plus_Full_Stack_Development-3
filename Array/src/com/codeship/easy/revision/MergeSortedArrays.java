package com.codeship.easy.revision;

public class MergeSortedArrays {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int k = nums1.length - 1; //same as m+n-1
		while(i >= 0 && j >= 0) {
			if(nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
		//if there are remaining elements in nums2, then copy them as it is becoz it is sorted in increasing 
		//order already
		while(j >= 0) {
			nums1[k--] = nums2[j--];
		}
		
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
