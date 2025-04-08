package org.codeship.single.LL.revision;

public class OddEvenLinkedList_WithoutExtraSpace {

	// TC: O(n)
	// SC: O(1)
	public ListNode oddEvenList(ListNode head) {
		// TC: O(n)
		// SC: O(1)
		// if list is empty or having one element
		if (head == null || head.next == null) {
			return head;
		}

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = head.next;

		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;

			odd = odd.next;
			even = even.next;
		}
		// changing link of last odd node to first even node
		odd.next = evenHead;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
