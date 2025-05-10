package org.binary.search.tree.revision;

public class ConvertBSTToGreaterTree {
	// TC: O(n)
	// SC: O(n) stack recursion space
	int prefixSum = 0;

	public TreeNode convertBST(TreeNode root) {
		// anti/reverse postorder
		dfs(root);
		return root;
	}

	private void dfs(TreeNode root) {
		// base case
		if (root == null)
			return;
		dfs(root.right);
		prefixSum += root.val;
		root.val = prefixSum;
		dfs(root.left);
	}
}
