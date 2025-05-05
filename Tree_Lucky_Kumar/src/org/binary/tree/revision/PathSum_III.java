package org.binary.tree.revision;

import java.util.*;

//TC: O(n)
// SC: O(n) stack space + O(n) hmap space
public class PathSum_III {

	int count = 0;

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return 0;

		Map<Long, Integer> hmap = new HashMap<>();
		hmap.put(0l, 1);
		dfs(root, 0l, targetSum, hmap);
		return count;
	}

	private void dfs(TreeNode root, Long prefixSum, int targetSum, Map<Long, Integer> hmap) {
		if (root == null)
			return;

		// Update prefix sum
		prefixSum += root.val;

		// Check if there exists a prefix sum that meets targetSum
		count += hmap.getOrDefault(prefixSum - targetSum, 0);

		// Store current prefix sum in map
		hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

		// Recurse left & right
		dfs(root.left, prefixSum, targetSum, hmap);
		dfs(root.right, prefixSum, targetSum, hmap);

		// Remove the current prefixSum entry for backtracking
		hmap.put(prefixSum, hmap.get(prefixSum) - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
