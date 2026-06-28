package com.codeship.medium.revision3;

import java.util.*;

public class PascalsTraingle {

	// TC: O(n^2)
	// SC: O(n^2)
	public List<List<Integer>> generate(int numRows) {
		int[][] arr = new int[numRows][numRows];
		List<List<Integer>> ans = new ArrayList<>();
		// build the pascal's triangle in the form of an array
		for (int i = 0; i < numRows; i++) {
			// fill first(i,0) & last cell(i,i)
			arr[i][0] = 1;
			arr[i][i] = 1;
			for (int j = 1; j < i; j++) {
				if (i - 1 >= 0 && j - 1 >= 0) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
		}

		for (int i = 0; i < numRows; i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				temp.add(arr[i][j]);
			}
			ans.add(temp);
		}

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
