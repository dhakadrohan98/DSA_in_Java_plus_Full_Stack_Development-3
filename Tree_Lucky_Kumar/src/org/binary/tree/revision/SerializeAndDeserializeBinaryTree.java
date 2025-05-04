package org.binary.tree.revision;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //edge case
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp == null) {
                sb.append("null,");
                continue;
            }
            sb.append(temp.val + ",");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.offer(root);
        for(int i = 1; i < str.length; i++) {
            TreeNode parent = q.poll();
            if(!str[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str[i]));
                parent.left = leftNode;
                q.offer(leftNode);
            }
            i += 1;
            if(!str[i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str[i]));
                parent.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
