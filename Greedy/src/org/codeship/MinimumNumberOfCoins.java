package org.codeship;

import java.util.*;

public class MinimumNumberOfCoins {

	// TC: O(n)
	// SC: O(1)
	public static List<Integer> minPartition(int V) {
		List<Integer> list = new ArrayList<>();
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
		int n = coins.length;
		int i = n - 1;
		while (i >= 0) {
			if (coins[i] <= V) {
				int times = V / coins[i];
				for (int j = 0; j < times; j++) {
					list.add(coins[i]);
				}
				V = V % coins[i];
			}
			if (V == 0) {
				break;
			}
			i--;
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
