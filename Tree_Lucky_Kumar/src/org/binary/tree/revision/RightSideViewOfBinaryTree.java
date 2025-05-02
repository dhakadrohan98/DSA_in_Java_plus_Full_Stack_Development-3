package org.binary.tree.revision;

import java.util.*;

public class RightSideViewOfBinaryTree {

	// TC: O(n)
	// SC: O(n-1)
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		// edge case
		if (root == null)
			return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		ans.add(root.val);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if(i == size-1) {
					ans.add(temp.val);
				}
				if (temp.left != null) {
					queue.offer(temp.left);
					list.add(temp.left.val);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
					list.add(temp.right.val);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
