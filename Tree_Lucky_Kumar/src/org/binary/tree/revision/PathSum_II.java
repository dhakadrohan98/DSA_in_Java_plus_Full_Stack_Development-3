package org.binary.tree.revision;

import java.util.*;

public class PathSum_II {
	//TC: O(n)
    //SC: O(n) + O(n) recursion stack space
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, targetSum, list, ans);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        //base case
        if(root == null) return;
        //add current val into sum
        sum += root.val;
        list.add(root.val);
        //curren node is a leaf node
        if(root.left == null && root.right == null && sum == targetSum) {
            ans.add(new ArrayList<>(list));
        }
        //left sub tree call
        dfs(root.left, sum, targetSum, list, ans);
        //right sub tree call
        dfs(root.right, sum, targetSum, list, ans);
        // Remove last element after both recursive calls (backtracking)
        list.remove(list.size() - 1);
        return;
    }
}
