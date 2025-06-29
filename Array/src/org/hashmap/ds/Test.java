package org.hashmap.ds;

public class Test {

	
	/**
	 * 
	 *       [-I, +I]
	 * arr = [10]
	 *      [-I, 10]    [10, +I]
	 *       5           20
	 *               [10, 20]  [20, +I]
	 *                 9        21
	 * 
	 * */
	
	//TC: O(2n)
	//SC: O(logn -  height of the tree)
	public boolean isBST(TreeNode root) {
		return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean dfs(TreeNode root, int leftMin, int rightMax) {
		//base case
		if(root == null) return true;
		if(root.val <= leftMin || root.val >= rightMax) {
			return false;
		}
		//going to ls
		boolean leftSubtree = dfs(root.left, leftMin, root.val);
		boolean rightSubtree = dfs(root.right, root.val, rightMax);
		return leftSubtree && rightSubtree;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
