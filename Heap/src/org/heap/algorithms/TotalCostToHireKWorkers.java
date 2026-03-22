package org.heap.algorithms;

import java.util.*;

public class TotalCostToHireKWorkers {
	// TC: O(n*nlogn) + O(k)
	// SC: O(n)
	public long totalCost(int[] costs, int k, int candidates) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		int n = costs.length;
		int i = 0;
		int j = n - 1;
		long totalCost = 0l;

		while (k-- > 0) {
			// push the element into pq1 & pq2
			while (pq1.size() < candidates && i <= j) {
				pq1.offer(costs[i]);
				i++;
			}
			while (pq2.size() < candidates && j >= i) {
				pq2.offer(costs[j]);
				j--;
			}
			// compare top elements of pq1 & pq2
			int pq1Min = !pq1.isEmpty() ? pq1.peek() : Integer.MAX_VALUE;
			int pq2Min = !pq2.isEmpty() ? pq2.peek() : Integer.MAX_VALUE;
			if (pq1Min <= pq2Min) {
				totalCost += pq1Min;
				pq1.poll();
			} else {
				totalCost += pq2Min;
				pq2.poll();
			}
		}
		return totalCost;
	}
}
