package org.heap.algorithms;

import java.util.*;

public class MinimumCostOfRopes {

	// TC: O(2 * (n *logn))
	// SC: O(n)
	public static int minCost(int[] arr) {
		// code here
		Queue<Integer> pq = new PriorityQueue<>();
		int minCost = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			pq.offer(arr[i]);
		}

		while (pq.size() > 1) {
			int firstRope = pq.poll();
			int secondRope = pq.poll();
			int currSum = firstRope + secondRope;
			minCost += currSum;
			pq.offer(currSum);
		}
		return minCost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
