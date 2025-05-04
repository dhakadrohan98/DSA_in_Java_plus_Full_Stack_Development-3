package org.binary.tree.revision;

import java.util.ArrayList;

public class PathToGivenNode {

	public ArrayList<Integer> solve(TreeNode root, int node) {
		ArrayList<Integer> list = new ArrayList<>();
		dfs(root, node, list);
		return list;
	}

	private boolean dfs(TreeNode root, int node, ArrayList<Integer> list) {
		// base case
		if (root == null)
			return false;
		list.add(root.val);

		if (root.val == node)
			return true;

		boolean lsr = dfs(root.left, node, list);
		boolean rsr = dfs(root.right, node, list);
		// if any dfs call find true it means we have reached till given node, return
		// from here propogate manner
		if (lsr || rsr)
			return true;
		// backrtacking remove the last element
		list.remove(list.size() - 1);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
