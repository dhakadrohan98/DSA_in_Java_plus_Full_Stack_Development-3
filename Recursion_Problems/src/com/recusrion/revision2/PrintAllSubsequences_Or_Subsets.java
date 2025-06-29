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

	        //include the current element
	        ds.add(arr[indx]);
	        f(indx+1, arr, ds, ans);
	        ds.remove(ds.size() - 1);
	        f(indx+1, arr, ds, ans);
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
