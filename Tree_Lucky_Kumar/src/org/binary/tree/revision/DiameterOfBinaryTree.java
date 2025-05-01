package org.binary.tree.revision;

public class DiameterOfBinaryTree {
	
	//Height of a node -> total no. of nodes from the given node to leaf node
    //Diameter of a node is the sum of left subtree height + right subtree height
    //TC: O(n)
    //SC: O(n)
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxi;
    }

    private int height(TreeNode root) {
        //base case
        if(root == null) return 0;
        int lsh = height(root.left);
        int rsh = height(root.right);
        maxi = Math.max(maxi, lsh + rsh);
        return 1 + Math.max(lsh, rsh);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
