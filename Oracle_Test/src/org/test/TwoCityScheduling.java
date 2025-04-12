package org.test;

import java.util.PriorityQueue;

class Pair {
	int a;
	int b;
	int diff;

	Pair(int a, int b, int diff) {
		this.a = a;
		this.b = b;
		this.diff = diff;
	}
}

public class TwoCityScheduling {

	// TC: O(n) + O(n * logn)
	// SC: O(n)
	public int twoCitySchedCost_AllTestCasesPassed(int[][] costs) {
		int n = costs.length;
		int costDiff = -1;
		int A = n / 2;
		int B = n / 2;
		int totalCost = 0;
		// max -heap basis on the diff_cost (b-a) which will give max profit for sending persons to city A rather than B.
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.diff - a.diff);
		for (int i = 0; i < n; i++) {
			costDiff = costs[i][1] - costs[i][0];
			pq.offer(new Pair(costs[i][0], costs[i][1], costDiff));
		}

		// send n/2 person to city A
		for (int i = 0; i < n / 2; i++) {
			Pair p = pq.poll();
			totalCost += p.a;

		}

		// send remaining n/2 persons to city B
		for (int i = 0; i < n / 2; i++) {
			Pair p = pq.poll();
			totalCost += p.b;

		}
		return totalCost;

	}

	// TC: O(n) + O(n * logn)
	// SC: O(n)
	// 28 test cases are passed out of 50
	public int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
		int costDiff = -1;
		int A = n / 2;
		int B = n / 2;
		int totalCost = 0;
		// min -heap basis on the diff_cost (b-a)
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
		for (int i = 0; i < n; i++) {
			costDiff = costs[i][1] - costs[i][0];
			pq.offer(new Pair(costs[i][0], costs[i][1], costDiff));
		}

		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int aCost = p.a;
			int bCost = p.b;
			if (aCost <= bCost) {
				if (A >= 1) {
					totalCost += aCost;
					A--;
				} else { // B >= 1
					totalCost += bCost;
					B--;
				}
			} else if (B >= 1) {
				totalCost += bCost;
				B--;
			} else {
				totalCost += aCost;
				A--;
			}
		}
		return totalCost;

	}

	public static void main(String[] args) {

	}

}
