package org.binary.tree.revision;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		dfs(root);
		return root;
	}

	private void dfs(TreeNode root) {
		// base case
		if (root == null)
			return;

		dfs(root.left);
		dfs(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
