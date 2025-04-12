package org.binary.tree.revision;

import java.util.*;
import org.binary.tree.TreeNode;

public class ZigZagLevelOrderTraversal {

	// TC: O(n)
	// SC: O(n)
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		int level = 0;
		if (root == null) {
			return ans;
		}
		// initial cofiguration
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> curr = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				curr.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			level++;
			if (!leftToRight) {
				Collections.reverse(curr);
			}
			leftToRight = !leftToRight;
			ans.add(curr);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
