package com.recusrion.revision;

import java.util.*;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0, target, arr, ds, ans);
        return ans;
    }

    private void helper(int indx, int target, int[] arr, List<Integer> ds ,List<List<Integer>> ans) {
        //base cases
        //target becomes equal to 0
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(indx >= arr.length) {   
            return;
        }

        if(target >= arr[indx]) {
            ds.add(arr[indx]);
            helper(indx, target - arr[indx], arr, ds, ans);
            ds.remove(ds.size() - 1);
        }
        helper(indx+1, target, arr, ds, ans);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
