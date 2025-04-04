package org.codeship.single.LL;

class ListNode {
	
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int data, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
public class ReverseSingleLinkedList {

	public ListNode reverseList(ListNode head) {
        //recursive approach
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
	
	public static void main(String[] args) {
		

	}

}
