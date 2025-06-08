package org.leetcodemedium.arr.revision2;

public class RearrangeArrayElementsBySign {
	
	//TC: O(n)
    //SC: O(n) can you solve without extra space?
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int j = 0, k = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                neg[k++] = nums[i];
            } else {
                pos[j++] = nums[i];
            }
        }
        int[] ans = new int[n];
        int i = 0;
        j = 0;
        k = 0;
        while(k < n) {
           if(k % 2 == 0) {
            ans[k] = pos[i++];
           } else {
            ans[k] = neg[j++];
           }
           k += 1;
        }
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
