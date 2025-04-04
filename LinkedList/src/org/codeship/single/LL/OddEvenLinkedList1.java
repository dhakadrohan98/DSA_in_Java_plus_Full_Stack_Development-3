package org.codeship.single.LL;

public class OddEvenLinkedList1 {

	public ListNode oddEvenList(ListNode head) {
		// TC: O(n)
		// SC: O(1)
		// if list is empty or having one element only
		if (head == null || head.next == null) {
			return head;
		}

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = head.next;

		while (even != null && even.next != null) {
			odd.next = odd.next.next; //storing next of next of odd node to odd.next
			even.next = even.next.next; //storing next of next of even node to even.next
			odd = odd.next; //move odd node by two step ahead
			even = even.next; //move even node by two step ahead
		}
		// changing link of last odd node to first even node i.e. evenHead
		odd.next = evenHead;
		return head;
	}

	public static void main(String[] args) {

	}

}
