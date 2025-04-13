package org.codeship;

import java.util.*;
public class TwoCityScheduling {
	
	class Pair {
	    int a;
	    int b;
	    int diff;

	    Pair(int a, int b,int diff) {
	        this.a = a;
	        this.b = b;
	        this.diff = diff;
	    }
	}

	class Solution {
	    //TC: O(n) + O(n * logn)
	    //SC: O(n)
	    public int twoCitySchedCost(int[][] costs) {
	        int n = costs.length;
	        int costDiff = -1;
	        int A = n/2;
	        int B = n/2;
	        int totalCost = 0;
	        //max -heap basis on the diff_cost (b-a) which will give max profit
	        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.diff - a.diff);
	        for(int i = 0; i < n; i++) {
	            costDiff = costs[i][1] - costs[i][0];
	            pq.offer(new Pair(costs[i][0], costs[i][1], costDiff));
	        }

	       //send n/2 person to city A
	       for(int i = 0; i < n/2; i++) {
	            Pair p = pq.poll();
	            totalCost += p.a;
	            
	       }

	       //send remaining n/2 persons to city B
	        for(int i = 0; i < n/2; i++) {
	            Pair p = pq.poll();
	            totalCost += p.b;
	            
	       }
	        return totalCost;

	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
