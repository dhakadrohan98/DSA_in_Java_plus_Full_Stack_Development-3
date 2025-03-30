package org.leetcodemedium.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals_OptimalSolution {

	// Optimal solution
	// TC: O(n*logn) + O(n) 1 pass
	// SC: O(n)
	public static int[][] merge(int[][] intervals) {
		int n = intervals.length; // size of the array
		// sort the given intervals:
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		System.out.println("Sorted arrays: ");
		for (int i = 0; i < intervals.length; i++) {
			System.out.print("{");
			for (int j = 0; j < 2; j++) {
				System.out.print(+intervals[i][j] + " ");
			}
			System.out.print("}, ");
		}

		System.out.println();
		// List of 1D array
		List<int[]> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) { // select an interval:
			int start = intervals[i][0];
			int end = intervals[i][1];

			if (ans.isEmpty() || start > ans.get(ans.size() - 1)[1]) {
				ans.add(intervals[i]);
			} else {
				int firstOfBackElement = ans.get(ans.size() - 1)[0];
				int lastOfBackElement = ans.get(ans.size() - 1)[1];
				int lastPosition = ans.size() - 1;
				int[] temp = { firstOfBackElement, Math.max(end, lastOfBackElement) };
				ans.set(lastPosition, temp);
			}
		}

		int[][] result = new int[ans.size()][2];
		for (int i = 0; i < ans.size(); i++) {
			result[i] = ans.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
		int[][] merge = merge(intervals);
		System.out.println("Merged intervals:");
		for (int i = 0; i < merge.length; i++) {
			System.out.print("{");
			for (int j = 0; j < 2; j++) {
				System.out.print(merge[i][j] + " ");
			}
			System.out.print("}, ");
		}
	}
}
