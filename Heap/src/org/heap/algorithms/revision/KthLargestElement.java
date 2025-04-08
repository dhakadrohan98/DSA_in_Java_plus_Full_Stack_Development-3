package org.heap.algorithms.revision;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
	
	//TC: O(n*2*logk)
    //SC: O(k)
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int i = 0;
        while(i < n) {
            pq.offer(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
            i++;
        }
        return pq.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
