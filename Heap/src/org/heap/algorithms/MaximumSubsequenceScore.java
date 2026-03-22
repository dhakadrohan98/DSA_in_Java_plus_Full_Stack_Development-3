package org.heap.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

	public static long maxScore(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		// pair (b, a)
		int[][] mixed = new int[n][2];

		for (int i = 0; i < n; i++) {
			mixed[i][0] = nums2[i];
			mixed[i][1] = nums1[i];
		}

		Arrays.sort(mixed, (a, b) -> {
			if (a[0] == b[0]) {
				// sort on the basis of nums1
				return Integer.compare(b[1], a[1]);
			}
			// sort on the basis of nums2
			return Integer.compare(b[0], a[0]);
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		long sum = 0;

		for (int i = 0; i <= k - 1; i++) {
			pq.offer(mixed[i][1]);
			sum += mixed[i][1];
		}
		long maxi = sum * mixed[k - 1][0];

		for (int i = k; i < n; i++) {
			sum = sum + mixed[i][1] - pq.poll();
			pq.offer(mixed[i][1]);
			maxi = Math.max(maxi, (long )(sum * mixed[i][0]));
		}
		return maxi;

	}

	public static void main(String[] args) {
		int[] nums1 = {1,3,3,2};
		int[] nums2 = {2,1,3,4};
		int k = 3;
		System.out.println(maxScore(nums1, nums2, k));
	}

}
