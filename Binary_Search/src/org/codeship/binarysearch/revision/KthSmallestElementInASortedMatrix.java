package org.codeship.binarysearch.revision;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

	//Brute force approach
	// TC: O(n logk)
	// SC: O(k) k -> size of Max heap
	public int kthSmallest(int[][] mat, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int n = mat.length;
		int m = mat[0].length;
		// TC: O(n logk)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				pq.offer(mat[i][j]);

				if (pq.size() > k) {
					pq.poll();
				}
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
