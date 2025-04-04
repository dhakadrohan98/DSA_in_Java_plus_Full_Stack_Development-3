package org.codeship.single.LL.revision;

public class DeleteNodeInLinkedList_HeadNotGiven {
	//TC: O(n)
	//SC: O(1)
	public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        // ListNode temp = node;
        prev.next = null;
    }
}
