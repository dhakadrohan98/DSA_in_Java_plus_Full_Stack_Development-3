package com.codeship.easy.revision;

public class BestTimeToBuyandSellStock {

	// TC: O(n)
	// SC: O(1)
	public int maxProfit(int[] prices) {
		int maxi = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - minPrice;
			maxi = Math.max(maxi, profit);
			if (minPrice > prices[i]) {
				minPrice = prices[i];
			}
		}
		return maxi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
