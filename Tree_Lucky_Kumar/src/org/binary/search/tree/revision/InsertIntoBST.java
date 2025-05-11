package org.binary.search.tree.revision;

public class InsertIntoBST {
	// TC: O(n) worst case, average case -> O(logn)
	// SC: O(n) worst case in case of skew tree
	public TreeNode insertIntoBST(TreeNode root, int val) {
		// edge case, when root is null & val is the first node
		if (root == null) {
			return new TreeNode(val);
		}
		dfs(root, null, -1, val);
		return root;
	}

	private void dfs(TreeNode root, TreeNode prev, int side, int val) {
		// base case
		if (root == null) {
			TreeNode newNode = new TreeNode(val);
			//if new node need to be attached with the prev node's left pointer
			if (side == 0) {
				prev.left = newNode;
			}
			//if new node need to be attached with the prev node's right pointer
			else { 
				prev.right = newNode;
			}
			return;
		}

		if (val < root.val) {
			dfs(root.left, root, 0, val);
		} else {
			dfs(root.right, root, 1, val);
		}
	}
}
