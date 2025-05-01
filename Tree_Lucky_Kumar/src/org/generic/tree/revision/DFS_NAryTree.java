package org.generic.tree.revision;

import java.util.ArrayList;
import java.util.List;

//TC: O(n) n -> total no. of nodes
//SC: O(logn) average case due to stack space
//SC: O(n) worst case due to skew tree

public class DFS_NAryTree {
	
	private static void dfs(Node root) {
		//base case
		if(root.children == null) {
			return;
		}
		
		String str = root.val + " -> ";
		List<Node> list = root.children;
		//children of current node
		int childrensSize = list.size();
		for(int i = 0; i < childrensSize; i++) {
			str = str + list.get(i).val + ", ";
		}
		//print current root & its child node
		System.out.println(str);
		
		//call dfs function on each child of current node(i.e. considered as root node)
		for(int i = 0; i < childrensSize; i++) {
			dfs(list.get(i));
		}
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
		
		dfs(root);

	}

}
