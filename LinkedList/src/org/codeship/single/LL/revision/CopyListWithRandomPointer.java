package org.codeship.single.LL.revision;

import java.util.HashMap;
import java.util.Map;

class Node1 {
	
	int val;
	Node1 next;
	Node1 random;
	
	public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

	// TC: O(2*n)
	// SC: O(n) map space + O(n) creating all Node1s for deep copy
	public Node1 copyRandomList(Node1 head) {
		Map<Node1, Node1> hmap = new HashMap<>();
		Node1 temp = head;
		// make all Node1 with respective values & map it with old Node1 of the same value
		while (temp != null) {
			Node1 newNode1 = new Node1(temp.val);
			hmap.put(temp, newNode1);
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			Node1 newNode = hmap.get(temp);
			newNode.next = hmap.get(temp.next);
			newNode.random = hmap.get(temp.random);
			temp = temp.next;
		}
		return hmap.get(head);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
