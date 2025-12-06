package payu.twopointer;

import java.util.Arrays;

public class _3SumClosest {

	// TC: O(n^2)
	// SC: O(1)
	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int ans = 0;
		// three pointer approach
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int curr_diff = Math.abs(sum - target);
				if (curr_diff < diff) {
					diff = curr_diff;
					ans = sum;
				}
				// conditionally increment/decrement j & k pointer
				if (sum < target) {
					j++;
				} else if (sum > target) {
					k--;
				} else { // sum == target
					return sum;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
