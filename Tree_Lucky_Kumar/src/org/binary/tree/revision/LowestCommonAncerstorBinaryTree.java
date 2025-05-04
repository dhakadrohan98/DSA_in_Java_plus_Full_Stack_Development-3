package org.binary.tree.revision;

public class LowestCommonAncerstorBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode leftSide = lowestCommonAncestor(root.left, p, q);
		TreeNode rightSide = lowestCommonAncestor(root.right, p, q);
		if (leftSide == null)
			return rightSide;
		else if (rightSide == null)
			return leftSide;
		else
			return root; // both leftSide & rightSide are not null
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
