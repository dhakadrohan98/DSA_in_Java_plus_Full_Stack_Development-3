package org.binary.tree.revision;

public class PathSum_I {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		return dfs(root, 0, targetSum);
	}

	private boolean dfs(TreeNode root, int sum, int targetSum) {
		// base case
		if (root == null)
			return false;
		sum += root.val;
		// check for leaf node
		if (root.left == null && root.right == null) {
			return sum == targetSum;
		}
		boolean leftSubTreeSum = dfs(root.left, sum, targetSum);
		boolean rightSubTreeSum = dfs(root.right, sum, targetSum);
		return leftSubTreeSum || rightSubTreeSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
