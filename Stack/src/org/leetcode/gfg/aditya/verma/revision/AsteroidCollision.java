package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

// 245/275 test cases are passed
public class AsteroidCollision {

	// My idea: Moving from right to left
	// Correct idea: Move from left to right
	// TC: O(n)
	// SC: O(n)
	public int[] asteroidCollision(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		st.push(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			// taking absolute value of curr element & top of the stack if stack is not
			// empty
			int abs1 = Math.abs(arr[i]);
			int abs2 = 0;
			if (!st.isEmpty()) {
				abs2 = Math.abs(st.peek());
			}
			// collision case
			if (arr[i] > 0 && !st.isEmpty() && st.peek() < 0) {
				if (abs1 < abs2) {
					continue;
				} else if (abs1 > abs2) {
					st.pop();
					st.push(arr[i]);
				} else {
					// arr[i] = st.peek();
					// same size asteroid will explode
					st.pop();
				}
			} else {
				// not a collision case
				st.push(arr[i]);
			}
		}
		System.out.println(st);
		// copy stack elements into res array
		int[] res = new int[st.size()];
		int k = 0;
		while (!st.isEmpty()) {
			res[k++] = st.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
