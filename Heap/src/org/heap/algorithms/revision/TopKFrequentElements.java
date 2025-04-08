package org.heap.algorithms.revision;

import java.util.*;

class Pair {
	int num;
	int freq;

	Pair(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}
}

public class TopKFrequentElements {

	// TC: O(n * 2 * logk)
	// SC: O(n) hmap + O(k) PQ<Pair>
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		// O(n)
		for (int num : nums) {
			hmap.put(num, hmap.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

		// TC: O(n * 2 * logk)
		// iterate through hmap
		for (Map.Entry<Integer, Integer> map : hmap.entrySet()) {
			int key = map.getKey();
			int val = map.getValue();
			if (pq.size() < k) {
				pq.offer(new Pair(key, val));
			}
			// pq.size() >= k
			else if (pq.peek().freq < val) {
				// remove the least freq element to make a space for greater frequency element
				pq.poll();
				pq.offer(new Pair(key, val));
			}
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll().num;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
