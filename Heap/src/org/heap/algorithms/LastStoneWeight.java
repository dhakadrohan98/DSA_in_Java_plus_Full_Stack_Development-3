package org.heap.algorithms;

import java.util.PriorityQueue;

public class LastStoneWeight {
	
	public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
        int n = stones.length;
        int lastStones = 0;
        for(int i = 0; i < n; i++) {
        	pq.offer(stones[i]);
        }
        
        while(!pq.isEmpty()) {
        	int y = pq.poll();
        	if(!pq.isEmpty()) {
        		int x = pq.poll();
        		int remainingWeight = y - x;
        		pq.offer(remainingWeight);
        	} else {
        		lastStones = y;
        		break;
        	}
        }
        return lastStones;
    }
	
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		System.out.println(lastStoneWeight(stones));
		
	}

}
