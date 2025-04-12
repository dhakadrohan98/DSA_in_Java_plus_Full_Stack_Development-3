package org.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	 public List<List<Integer>> levelOrder(TreeNode root) {
	        
	        List<List<Integer>> ans = new ArrayList<>();
	        //base case
	        if (root == null) {
	          return ans;   
	        }
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        
	        while (!queue.isEmpty()) {
	          List<Integer> currLevel = new ArrayList<>();
	          //how many nodes to be traversed at the current level
	          int size = queue.size();
	          for (int i = 0; i < size; i++) {
	            TreeNode node = queue.poll();
	            currLevel.add(node.val);
	            if (node.left != null)
	              queue.offer(node.left);
	            if (node.right != null)
	              queue.offer(node.right);
	          }
	          ans.add(currLevel);
	        }

	        return ans;
	  }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
