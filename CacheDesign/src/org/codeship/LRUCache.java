package org.codeship;

import java.util.Map;
import java.util.HashMap;

//Average TC
//TC: O(1) on average
//SC: O(ns)

//worst case
//TC: O(logn)
//SC: O(n)
public class LRUCache {
	
	class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    private Map<Integer, Node> hmap = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //making head & prev dummy node for ease
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    //insert() method
    public void insert(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    
    public void delete(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
         //set next & prev of to be delete node to null.
        node.next = node.prev = null;
    }


    public int get(int key) {
        if(hmap.size() > 0 && hmap.containsKey(key)) {
            Node node = hmap.get(key);
            //delete that node & insert again so that lru node will shift towards the left
            //(just previous to the tail node)
            delete(node);
            insert(node);
            return node.val;
        }
        //in other cases, key is not found return -1.
        return -1;
    }
    
    public void put(int key, int value) {
        //
        if(hmap.size() <= this.capacity && hmap.containsKey(key)) {
            //on updation of value for a given key, update the value in the node for a given key
            //& then delete that node & insert again so that lru node will shift towards the left
            //(just previous to the tail node)
            Node node = hmap.get(key);
            node.val = value;
            delete(node);
            insert(node);
        }
        else {
            //lru capacity is full. Delete the node from lru & map both & then insert again the new node into lru & map both.
            if(hmap.size() >= this.capacity) {
                Node lru = tail.prev;
                //delete tail.prev node
                delete(tail.prev);
                //remove node key from map
                hmap.remove(lru.key);
            }
            //insert a new node into lru & map both
            Node node = new Node(key, value);
            insert(node);
            hmap.put(key, node);
        }

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
