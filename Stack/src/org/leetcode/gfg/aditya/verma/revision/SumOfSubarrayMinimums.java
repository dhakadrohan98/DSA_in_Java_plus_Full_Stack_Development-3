package org.leetcode.gfg.aditya.verma.revision;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums {

	// TC: O(3*n)
	// SC: O(4*n)
	public int[] findNextSmallerElement(int[] arr, int n) {
		int[] nse = new int[n];
		Deque<Integer> st = new ArrayDeque<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			nse[i] = st.isEmpty() ? n : st.peek();
			st.push(i);
		}
		return nse;
	}

	public int[] findPreviousSmallerOrEqualElement(int[] arr, int n) {
		int[] psse = new int[n];
		Deque<Integer> st = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
				st.pop();
			}
			psse[i] = st.isEmpty() ? -1 : st.peek();
			st.push(i);
		}
		return psse;
	}

	public int sumSubarrayMins(int[] arr) {
		int n = arr.length;
		int[] nse = findNextSmallerElement(arr, n);
		int[] psee = findPreviousSmallerOrEqualElement(arr, n);
		long total = 0;
		int mod = (int) 1e9 + 7;
		for (int i = 0; i < n; i++) {
			long leftSubarray = i - psee[i];
			long rightSubarray = nse[i] - i;
			total = (total + (rightSubarray * leftSubarray * arr[i]) % mod) % mod;
		}
		return (int) total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
