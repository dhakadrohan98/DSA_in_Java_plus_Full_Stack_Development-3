package org.codeship;

import java.util.*;

//Priority Queue approach
public class TaskScheduler {

	// TC: O(n * logk) insertion from map into pq + O(logk) deletion from pq
	// where k is 26 (A-Z)
	// SC: O(26)
	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		// count the frequency of each character
		for (char ch : tasks) {
			map[ch - 'A']++;
		}

		int time = 0;
		// max heap
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		// push all characters occurences in pq
		for (int i = 0; i < 26; i++) {
			if (map[i] > 0) {
				pq.offer(map[i]);
			}
		}

		while (!pq.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			// n+1 tasks
			for (int i = 1; i <= n + 1; i++) {
				if (!pq.isEmpty()) {
					int freq = pq.poll();
					freq--;
					temp.add(freq);
				}
			}

			// if present freq in temp is greater than 0, again push it into PQ
			for (int freq : temp) {
				if (freq > 0) {
					pq.offer(freq);
				}
			}

			if (pq.isEmpty()) {
				time += temp.size();
			} else {
				time += n + 1; // task
			}
		}
		return time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
