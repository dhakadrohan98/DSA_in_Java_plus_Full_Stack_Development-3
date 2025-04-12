package org.test;

import java.util.*;

public class TwoCityScheduling_AllTestCasesPassed {
	
	class Pair {
	    int a;
	    int b;
	    int diff;

	    Pair(int a, int b) {
	        this.a = a;
	        this.b = b;
	        this.diff = a - b; // Sorting by A - B
	    }
	}

	class Solution {
	    public int twoCitySchedCost(int[][] costs) {
	        int n = costs.length;
	        List<Pair> list = new ArrayList<>();
	        
	        for (int[] cost : costs) {
	            list.add(new Pair(cost[0], cost[1]));
	        }

	        // Sort by difference (A - B), so we send people with cheaper A-costs first
	        list.sort((p1, p2) -> p1.diff - p2.diff);

	        int totalCost = 0;

	        // First n/2 go to city A
	        for (int i = 0; i < n / 2; i++) {
	            totalCost += list.get(i).a;
	        }

	        // Remaining n/2 go to city B
	        for (int i = n / 2; i < n; i++) {
	            totalCost += list.get(i).b;
	        }

	        return totalCost;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
