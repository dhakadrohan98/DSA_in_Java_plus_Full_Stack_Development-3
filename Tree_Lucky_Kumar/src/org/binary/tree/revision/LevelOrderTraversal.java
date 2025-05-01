package org.binary.tree.revision;

import java.util.*;

public class LevelOrderTraversal {

	// TC: O(n)
	// SC: < O(n)
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		// edge case
		if (root == null)
			return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		queue.offer(root);
		list.add(root.val);
		ans.add(list);

		while (!queue.isEmpty()) {
			list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (temp.left != null) {
					queue.offer(temp.left);
					list.add(temp.left.val);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
					list.add(temp.right.val);
				}
			}
			if (!list.isEmpty()) {
				ans.add(list);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
