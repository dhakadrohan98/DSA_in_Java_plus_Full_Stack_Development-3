package org.generic.tree.revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalNAryTree {

	public static ArrayList<ArrayList<Integer>> bfs(Node root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		// base case
		if (root == null)
			return ans;

		Deque<Node> queue = new ArrayDeque<Node>();
		queue.offer(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		ans.add(new ArrayList<Integer>(list));
		while (!queue.isEmpty()) {
			list = new ArrayList<Integer>();
			Node temp = queue.poll();
			if(temp.children == null) continue;
			List<Node> childrens = temp.children;
			for (int i = 0; i < childrens.size(); i++) {
				list.add(childrens.get(i).val);
				queue.offerLast(childrens.get(i));
			}
			ans.add(new ArrayList<Integer>(list));
		}
		return ans;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		root.children = new ArrayList<>();
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);

		node2.children = new ArrayList<>();
		node2.children.add(node4);
		node2.children.add(node5);

		ArrayList<ArrayList<Integer>> bfsTraversal = bfs(root);
		System.out.println(bfsTraversal);
		System.out.println("Levels - " + bfsTraversal.size());

	}

}
