package com.recusrion.revision;

import java.util.ArrayList;

public class SubSetSum_I {
	
	//TC: O(2^n)
    //SC O(n) recursion stack space + O(2^n) stores sum
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        helper(n-1, 0, arr, ans);
        return ans;
    }
    
    private void helper(int indx, int sum, int[] arr, ArrayList<Integer> ans) {
        //base case
        if(indx < 0) {
            ans.add(sum);
            return;
        }
        //add curr element into sum
        helper(indx-1, sum + arr[indx], arr, ans);
        //not pick
        helper(indx-1, sum, arr, ans);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
