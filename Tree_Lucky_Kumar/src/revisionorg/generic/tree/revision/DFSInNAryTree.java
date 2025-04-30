package revisionorg.generic.tree.revision;

import java.util.ArrayList;
import java.util.List;

//TC: O(n) n -> total no. of nodes
//SC: O(logn) average case due to stack space
//SC: O(n) worst case due to skew tree
class TreeNode {
	
	int val;
	List<TreeNode> children;
	
	public TreeNode(int val) {
		this.val = val;
	}
}

public class DFSInNAryTree {
	
	private static void dfs(TreeNode root) {
		//base case
		if(root.children == null) {
			return;
		}
		
		String str = root.val + " -> ";
		List<TreeNode> list = root.children;
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
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
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
