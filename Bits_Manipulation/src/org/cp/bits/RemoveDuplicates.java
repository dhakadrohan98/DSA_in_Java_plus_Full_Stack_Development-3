package org.cp.bits;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//eliminate even number & print odd one only
		int[] nums = {2,3,4,3,4,2,5,9,10,9,10};
		int ans = 0;
		for(int i = 1; i < nums.length; i++) {
			ans ^= nums[i];
		}
		System.out.println("unique element: " + ans);

	}

}
