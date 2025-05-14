package org.binary.search.tree.revision;

import java.util.*;

public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		dfs(root, list);
		return list.get(k - 1);
	}

	private void dfs(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		dfs(root.left, list);
		list.add(root.val);
		dfs(root.right, list);
	}
}
