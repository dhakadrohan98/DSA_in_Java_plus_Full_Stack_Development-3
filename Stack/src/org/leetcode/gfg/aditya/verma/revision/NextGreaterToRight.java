package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

public class NextGreaterToRight {
	// TC: O(n)
	// SC: O(n) due to stack
	public static int[] nextGreaterElement(int[] arr, int n) {
		int[] res = new int[n];
		Stack<Integer> st = new Stack<>();
		res[n - 1] = -1;
		st.push(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			// pop all smaller & greater elements
			while (!st.isEmpty() && arr[i] >= st.peek()) {
				st.pop();
			}
			// if stack is not empty then greater element is at the top of the stack
			if (!st.isEmpty()) {
				res[i] = st.peek();
			}
			// no greater element is found on the right
			else {
				res[i] = -1;
			}
			// Push current element for future comparisons
			st.push(arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
