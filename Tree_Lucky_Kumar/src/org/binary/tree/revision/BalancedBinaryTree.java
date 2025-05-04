package org.binary.tree.revision;

public class BalancedBinaryTree {
	// TC: O(n)
	// SC: O(n) in case of skew tree

	boolean ans = true;

	public boolean isBalanced(TreeNode root) {
		dfs(root);
		return ans;
	}

	private int dfs(TreeNode root) {
		// base case
		if (root == null)
			return 0;

		int lsh = dfs(root.left);
		int rsh = dfs(root.right);
		if (Math.abs(lsh - rsh) > 1) {
			ans = false;
			return 0;
		}
		return 1 + Math.max(lsh, rsh);

	}
}
