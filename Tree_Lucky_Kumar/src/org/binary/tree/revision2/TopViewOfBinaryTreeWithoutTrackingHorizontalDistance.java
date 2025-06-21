package org.binary.tree.revision2;

import java.util.*;

public class TopViewOfBinaryTreeWithoutTrackingHorizontalDistance {
	
	public static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> topView = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(i == 0 || i == size-1) {
                    topView.add(node.data);
                }
            }
        }
        return topView;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
