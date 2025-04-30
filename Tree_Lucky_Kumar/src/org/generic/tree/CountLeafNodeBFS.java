package org.generic.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountLeafNodeBFS {

	static int count = 0;

	public static int countLeafBfs(TreeNode1 root) {
		// Through BFS (level order traversal)
		if (root == null)
			return count;
		Queue<TreeNode1> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode1 temp = q.poll();
				List<TreeNode1> childs = temp.children;

				if (childs.size() == 0) {
					count++;
				}
				for (int j = 0; j < temp.children.size(); j++)
					q.add(temp.children.get(j));
			}
			System.out.println();
		}

		return count;
	}

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(100);
		TreeNode1 node1 = new TreeNode1(1);
		TreeNode1 node2 = new TreeNode1(2);
		TreeNode1 node3 = new TreeNode1(3);
		TreeNode1 node4 = new TreeNode1(4);
		TreeNode1 node5 = new TreeNode1(5);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		node1.children.add(node4);
		node1.children.add(node5);
		int ans = countLeafBfs(root);
		System.out.println(ans);

	}

}
