package org.binary.tree.revision;

import java.util.*;

public class BoundaryTraversalOfBinaryTree {

	//TC: O(n + n/2 + n/2)
	//SC: O(n) stack space (skew tree)
	public ArrayList<Integer> boundary(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		// base case
		if (root == null) {
			return res;
		}
		// add root node data if it is not a leaf node
		if (!isLeaf(root)) {
			res.add(root.data);
		}
		// add left boundary
		addLeftBoundary(root.left, res);
		// add leaves
		addLeaves(root, res);
		// add right boundary
		addRightBoundary(root.right, res);

		return res;
	}

	public void addLeftBoundary(Node root, ArrayList<Integer> res) {
		Node temp = root;
		while (temp != null) {
			if (temp.left != null) {
				if (!isLeaf(temp)) {
					res.add(temp.data);
				}
				temp = temp.left;
			} else {
				if (!isLeaf(temp)) {
					res.add(temp.data);
				}
				temp = temp.right;
			}
		}
	}

	public void addRightBoundary(Node root, ArrayList<Integer> res) {
		Node temp = root;
		// Take one temporary list from reverse purposed
		List<Integer> list = new ArrayList<>();
		while (temp != null) {
			// move to the right node if right node is null then move to the left node
			if (temp.right != null) {
				if (!isLeaf(temp)) {
					list.add(temp.data);
				}
				temp = temp.right;
			} else {
				if (!isLeaf(temp)) {
					list.add(temp.data);
				}
				temp = temp.left;
			}
		}
		// reverse the list
		Collections.reverse(list);
		res.addAll(list);
	}

	public void addLeaves(Node root, ArrayList<Integer> res) {
		// base case
		if (root == null) {
			return;
		}

		if (isLeaf(root)) {
			res.add(root.data);
		}
		addLeaves(root.left, res);
		addLeaves(root.right, res);
	}

	private boolean isLeaf(Node temp) {
		return temp.left == null && temp.right == null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
