package org.codeship.single.LL.revision;

import org.codebix.Node;

public class InsertionAtTheLast {
	//TC: O(n)
	//SC: O(1)
	Node insertAtEnd(Node head, int x) {
        if(head == null) {
            return new Node(x);
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(x);
        return head;
    }
}
