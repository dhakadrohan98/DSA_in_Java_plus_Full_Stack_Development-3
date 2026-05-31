package com.codeship.easy.revision;

import java.util.*;

public class LeadersInArray {
	
	//TC: O(n)
	//SC: O(n)
	public static ArrayList<Integer> leaders(int arr[]) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans.add(0, arr[i]);
                st.push(arr[i]);
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
