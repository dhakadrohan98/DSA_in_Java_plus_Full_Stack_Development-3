package org.leetcodemedium.arr.revision2;

import java.util.*;;
public class ArrayLeaders {

	 //TC: O(n)
    //SC: O(n)
    public static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> leaders = new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        maxHeap.offer(arr[n-1]);
        leaders.add(arr[n-1]);
        
        for(int i = n - 2; i >= 0; i--) {
            if(maxHeap.peek() <= arr[i]) {
                leaders.add(arr[i]);
            }
            maxHeap.offer(arr[i]);
        }
        //reverse the leaders before returning
        int m = leaders.size();
        for(int i = 0; i < m / 2; i++) {
            int temp = leaders.get(i);
            int temp2 = leaders.get(m-1-i);
            leaders.set(i, temp2);
            leaders.set(m-1-i, temp);
        }
        
        return leaders;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
