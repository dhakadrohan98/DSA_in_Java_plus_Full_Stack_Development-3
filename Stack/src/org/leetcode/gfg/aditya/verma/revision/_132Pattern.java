package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

// 87/107 test cases are passed
public class _132Pattern {

	// Optimal approach
	// TC O(n)
	// SC: O(1)
	public boolean find132pattern_OptimalApproach(int[] nums) {
		Stack<Integer> st = new Stack<>();
		// st.push(nums[0]);
		int n = nums.length;
		int num3 = Integer.MIN_VALUE;
		// num3 = -Infinity
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] < num3)
				return true;
			// remove smaller elements from the stack & assign it to num3 because these are
			// best candidates to become num3
			while (!st.isEmpty() && nums[i] > st.peek()) {
				num3 = st.pop();
			}
			st.push(nums[i]);
		}
		return false;
	}

	// Better approach
	// TC O(n^2)
	// SC: O(1)
	public boolean find132pattern_BetterApproach(int[] nums) {
		// Stack<Integer> st = new Stack<>();
		// st.push(nums[0]);
		int n = nums.length;
		int num_i = nums[0];
		for (int j = 1; j < n - 1; j++) {
			// keep track of minimum always
			num_i = Math.min(num_i, nums[j]);
			for (int k = j + 1; k < n; k++) {
				if (num_i < nums[k] && nums[k] < nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// TC O(n)
	// SC: O(n)
	public boolean find132pattern(int[] nums) {
		Stack<Integer> st = new Stack<>();
		st.push(nums[0]);
		int n = nums.length;
		for (int i = 1; i < n - 1; i++) {
			int curr = nums[i];
			int next = nums[i + 1];
			if (st.peek() < next && next < curr) {
				return true;
			}
			st.push(curr);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
