package org.leetcodemedium.arr.revision;

import java.util.*;
public class NextPermutation_2 {
	
	//TC: O(3*n)
    //SC: O(1)
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int s, int e) {
        int i = s, j = e;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int mid = -1;
        //find the dip (longest prefix match)
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                mid = i;
                break;
            }
        }
        //no break point is found.
        if(mid == -1) {
            reverse(nums, 0, n-1);
            return;
        }
        //step-2
        for(int i = n-1 ; i > mid; i--) {
            if(nums[i] > nums[mid]) {
                swap(nums, mid, i);
                break;
            }
        }
        reverse(nums, mid+1, n-1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
