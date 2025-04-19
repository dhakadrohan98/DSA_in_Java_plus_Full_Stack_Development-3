package com.recusrion.revision;

import java.util.*;

public class CombinationSumII {
	
	public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr.length - 1, target, arr, ds, ans);
        return ans;
    }

    private void helper(int indx, int target, int[] arr, List<Integer> ds ,List<List<Integer>> ans) {
        //base cases
        //target becomes equal to 0
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(indx < 0 || target < 0) {   
            return;
        }

        // skip duplicates (this works correctly only if array is sorted)
        int i = indx;
        while (i >= 0) {
            if (i < indx && arr[i] == arr[i + 1]) {
                i--;
                continue;
            }

            ds.add(arr[i]);
            helper(i - 1, target - arr[i], arr, ds, ans);
            ds.remove(ds.size() - 1);
            i--;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
