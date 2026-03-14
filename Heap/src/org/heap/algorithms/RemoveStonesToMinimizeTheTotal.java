package org.heap.algorithms;

import java.util.*;

public class RemoveStonesToMinimizeTheTotal {

	class Pair {
		int val;
		int indx;

		public Pair(int val, int indx) {
			this.val = val;
			this.indx = indx;
		}
	}

	public int minStoneSum(int[] piles, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
		int minStones = 0;
		int n = piles.length;
		for (int i = 0; i < n; i++) {
			pq.offer(new Pair(piles[i], i));
		}

		while (k-- > 0) {
			Pair pair = pq.poll();
			int val = pair.val;
			int indx = pair.indx;

			int floor = (int) Math.floor(val / 2);
			// update the new reduced stone at indx in piles array & then push the new Pair
			// (new_val, indx) in pq again.
			piles[indx] = val - floor;
			pq.offer(new Pair(piles[indx], indx));
		}
		// Now array contains remaining store at each index after k operations
		for (int i = 0; i < n; i++) {
			minStones += piles[i];
		}

		return minStones;
	}
}
