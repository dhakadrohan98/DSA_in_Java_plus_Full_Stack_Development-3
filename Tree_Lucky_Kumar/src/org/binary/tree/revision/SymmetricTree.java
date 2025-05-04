package org.binary.tree.revision;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right); 
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
            if(left ==  null || right == null) {
                return left == right;
            }
            //if both are not null, then their value should be equal
            if(left.val != right.val) return false;
            //preorder -> root, left, right
            //Anti preorder -> root, right, left
            boolean isLeftSubtreeSymmetry = isSymmetricHelp(left.left, right.right);
            boolean isRightSubtreeSymmetry = isSymmetricHelp(left.right, right.left);
            return isLeftSubtreeSymmetry && isRightSubtreeSymmetry;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
