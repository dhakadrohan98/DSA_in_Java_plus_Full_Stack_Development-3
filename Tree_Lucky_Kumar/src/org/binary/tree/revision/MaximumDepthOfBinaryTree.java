package org.binary.tree.revision;

public class MaximumDepthOfBinaryTree {

	// TC: O(n)
	// SC: O(n)
	public int maxDepth(TreeNode root) {
		return dfs(root);
	}

	private int dfs(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		int lsh = dfs(root.left);
		int rsh = dfs(root.right);
		return 1 + Math.max(lsh, rsh);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
