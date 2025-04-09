package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

public class DailyTemperature {
	
	//TC: O(n)
    //SC: O(n)
    //pattern : monotonic stack
    public int[] dailyTemperatures(int[] arr) {
        Stack<Pair> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek().num <= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                int indx = st.peek().indx;
                res[i] = indx - i;
            } else {
                //no warmer temperature is found at the right side of current element
                res[i] = 0;
            }
            st.push(new Pair(arr[i], i));
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
