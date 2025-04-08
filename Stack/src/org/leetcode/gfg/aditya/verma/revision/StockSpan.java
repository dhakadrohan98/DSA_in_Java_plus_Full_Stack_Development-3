package org.leetcode.gfg.aditya.verma.revision;

import java.util.*;

public class StockSpan {

	// TC: O(n)
	// SC: O(n)
	static class Pair {
		int num;
		int indx;

		Pair(int num, int indx) {
			this.num = num;
			this.indx = indx;
		}
	}

	public static int[] findStockSpans(int[] prices) {
		int n = prices.length;
		int[] res = new int[n];
		Stack<Pair> st = new Stack<>();
		int prev = -1;
		int intMax = (int) 1e9;
		st.push(new Pair(intMax, -1));
		// count of smaller elements <= arr[i]
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && st.peek().num < prices[i]) {
				st.pop();
			}
			if (!st.isEmpty()) {
				int indx = st.peek().indx;
				int span = i - indx;
				res[i] = span;
			}
			st.push(new Pair(prices[i], i));
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
