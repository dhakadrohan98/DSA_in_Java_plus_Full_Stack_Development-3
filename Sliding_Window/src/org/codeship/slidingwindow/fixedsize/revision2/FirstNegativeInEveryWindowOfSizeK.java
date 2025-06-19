package org.codeship.slidingwindow.fixedsize.revision2;

import java.util.*;

public class FirstNegativeInEveryWindowOfSizeK {
	
	//TC: O(n)
    //SC: O(n)
    public static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int n = arr.length;
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        while(j < n) {
            //do some calculations
            if(arr[j] < 0) {
                queue.offer(arr[j]);
            }
            if(j - i + 1 < k) {
                j++;
            } else if(j - i + 1 == k) {
                //do calculations for ans
                if(!queue.isEmpty()) {
                    ans.add(queue.peek());
                } else {
                    ans.add(0);
                }
                //remove calculations for i
                if(queue.contains(arr[i])) {
                    queue.poll();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
