package org.binary.tree.revision;

import java.util.*;
public class LeftViewOfBinaryTree {
	 //TC: O(n)
    //SC: O(n)
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
		// edge case
		if (root == null) return ans;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();
				if(i == 0) {
					ans.add(temp.data);
				}
				if (temp.left != null) {
					queue.offer(temp.left);
					list.add(temp.left.data);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
					list.add(temp.right.data);
				}
			}
		}
		return ans;
    }
}
