package org.leetcodemedium.arr.revision2;

public class BestTimeToBuyAndSellStockII {
	
	 //TC: O(n)
    //SC: O(1)
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int buying = arr[0];
        int maxi = 0;
        for(int i = 1; i < n; i++) {
            int profit = arr[i] - buying;
            if(arr[i] > buying) {
                maxi += profit;
                buying = arr[i];
            } else if(arr[i] < buying) {
                buying = arr[i];
            }
        }
        return maxi;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
