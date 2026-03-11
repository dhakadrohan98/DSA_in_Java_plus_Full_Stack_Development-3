package com.recusrion.revision2;

import java.util.*;

public class PrintAllSubsequences_Or_Subsets {
	
	//TC: O(2^n * n(to copy all subsets element in ans list))
	//SC: O(n recursion stack space * 2^n - total number of substes) //height of the tree
	
	
	    private void f(int indx, int[] arr, List<Integer> ds, List<List<Integer>> ans) {
	        //base case
	        if(indx >= arr.length) {
	            ans.add(new ArrayList<>(ds));
	            return;
	        }

	        ds.add(arr[indx]); //pick the current element
	        f(indx + 1, arr, ds, ans); //next call
	        ds.remove(ds.size() - 1); //remove the last added element
	        f(indx + 1, arr, ds, ans); //not pick
	    }


	    public List<List<Integer>> subsets(int[] arr) {
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> ds = new ArrayList<>();
	        f(0, arr, ds, ans);
	        return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
