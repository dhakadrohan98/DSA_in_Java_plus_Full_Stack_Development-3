package org.codeship;

public class JumpGame {
	
	//TC: O(n)
    //SC: O(n)
    public boolean canJump_CorrectApproach(int[] nums) {
        int n = nums.length;
        int reachable = 0;
        for(int i = 0; i < n; i++) {
            //current index is greater than maximum reachable indx till now
            if(reachable < i) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
	
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
