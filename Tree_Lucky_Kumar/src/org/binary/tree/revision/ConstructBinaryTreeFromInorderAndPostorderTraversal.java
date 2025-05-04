package org.binary.tree.revision;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	// TC: O(n)
	// SC: O(n)
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) {
			return null;
		}
		int n = inorder.length;
		int m = postorder.length;

		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hm.put(inorder[i], i);
		}
		return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
	}

	private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
			Map<Integer, Integer> hm) {
		// base case
		if (ps > pe || is > ie)
			return null;

		TreeNode root = new TreeNode(postorder[pe]);
		int inRoot = hm.get(postorder[pe]);
		int numsLeft = inRoot - is;
		root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, hm);
		root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
