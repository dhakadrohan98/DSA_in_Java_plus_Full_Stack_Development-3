package org.binary.search.tree.revision;

public class DeleteANodeInBST {
	// TC: O(n)
	// SC: O(< n) stack space in findLastRight method
	// Steps
	// Search the node & then delete it
	public TreeNode deleteNode(TreeNode root, int key) {
		// base case
		if (root == null)
			return root;
		if (root.val == key) {
			return helper(root);
		}
		TreeNode dummy = root;

		while (root != null) {
			if (key < root.val) {
				if (root.left != null && root.left.val == key) {
					root.left = helper(root.left);
					break;
				} else {
					root = root.left;
				}
			} else {
				if (root.right != null && root.right.val == key) {
					root.right = helper(root.right);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return dummy;
	}

	private TreeNode helper(TreeNode root) {
		// edge cases
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}
		TreeNode rightChild = root.right;
		TreeNode lastRight = lastRight = findLastRight(root.left);
		lastRight.right = rightChild;
		return root.left;
	}

	private TreeNode findLastRight(TreeNode root) {
		// base case for recursion
		// if current node is leaf node of right subtree then return it
		if (root.right == null)
			return root;
		TreeNode ansNode = findLastRight(root.right);
		return ansNode;
	}

}
