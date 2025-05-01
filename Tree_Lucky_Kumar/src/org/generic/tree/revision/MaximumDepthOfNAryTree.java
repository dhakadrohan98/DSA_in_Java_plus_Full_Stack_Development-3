package org.generic.tree.revision;

import java.util.List;

//TC: O(n)
//SC: O(n) stack space worst case - skew tree 
public class MaximumDepthOfNAryTree {
	
	int depth = 0;

    public int maxDepth(Node root) {
        //edge case
        if(root == null) return 0;
        int level = 1;
        helper(root, level);
        return depth;
    }

    private void helper(Node root, int level) {
        //base cases
        //if current node is leaf node
        if(root.children.size() == 0) {
            depth = Math.max(depth, level);
            return;
        }

        List<Node> childrens = root.children;
        for(Node temp : childrens) {
            //recursive call on each child depth wise 
            helper(temp, level + 1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
