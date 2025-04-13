package org.codeship;

public class JumpGame {
	
	// 69/174 test cases are passed
	//TC: O(n)
	//SC: O(1)
	public boolean canJump(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int target_indx = i + nums[i];
            if(target_indx == n - 1) {
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
