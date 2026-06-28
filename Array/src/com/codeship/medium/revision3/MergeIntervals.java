package com.codeship.medium.revision3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair {

	int first;
	int second;

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

//TC: O(n*2 * log(n*2))
//SC: O(n)
public class MergeIntervals {

	public static void merge(int[][] arr) {
		int n = arr.length;
		List<Pair> list = new ArrayList<>();

		// sort the array of size (n*2)
		Arrays.sort(arr, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		});

		int i = 0;
		// merge the intervals
		while (i < n) {
			int firstM = arr[i][0];
			int secondM = arr[i][1];
			int j = i + 1;

			while (j < n && secondM >= arr[j][0]) {
				secondM = Math.max(secondM, arr[j][1]); // represent current merged intervals
				j++;
			}
			list.add(new Pair(firstM, secondM));
			i = j;
		}
		// print the merged list
//        for(Pair p : list) {
//        	System.out.println(p.first + "," + p.second);
//        }

	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
		merge(intervals);

	}

}
