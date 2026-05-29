package com.four.medium.revision;

public class BuyAndSellStock_II {

	// TC: O(n)
	// SC: O(1)
	/*
	 * Algorithm- calculate the profit first with current price, if it is positive then we have made profit with 
	 * current price and Now we have to buy the stock again on today's price to make next profit in the future
	 * */
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			// calculate the profit
			int profit = prices[i] - minPrice;
			// if profit is greater than 0, then add it to maxProfit
			if (profit > 0) {
				maxProfit += profit;

			}
			// buy the share at current price
			minPrice = prices[i];
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
