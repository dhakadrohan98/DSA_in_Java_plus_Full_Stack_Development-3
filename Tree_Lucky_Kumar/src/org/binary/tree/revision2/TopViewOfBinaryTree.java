package org.binary.tree.revision2;

import java.util.*;

public class TopViewOfBinaryTree {
	//TC: O(n)
    //SC: O(n)
    static class Pair {
        Node node;
        int hd;
        
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public static ArrayList<Integer> topView(Node root) {
        // code here
        Map<Integer, Integer> tmap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        tmap.put(0, root.data);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                Node node = pair.node;
                int hd = pair.hd;
                
                if(!tmap.containsKey(hd)) {
                    tmap.put(hd, node.data);
                }
                
                if(node.left != null) 
                    queue.offer(new Pair(node.left, hd-1));
                    
                if(node.right != null) 
                    queue.offer(new Pair(node.right, hd+1));
            }
        }
        ArrayList<Integer> topView = new ArrayList<>();
        //Tree map value contains the desired order of top view
        for(int val : tmap.keySet()) {
            topView.add(tmap.get(val));
        }
        
        return topView;
    }
}
