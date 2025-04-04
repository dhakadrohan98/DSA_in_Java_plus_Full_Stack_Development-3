package org.codeship.single.LL;

public class RemoveNthNodeFromEndOfList {

	// TC: O(2 * n)
	// SC: O(1)
	public ListNode removeNthFromEnd0(ListNode head, int n) {
		// keep track of the length of the node
		int count = 0;
		ListNode temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}
		// base case
		if (count == n) { // remove head of LL
			ListNode newHead = head.next;
			return newHead;
		}

		int res = count - n;
		temp = head;
		while (temp != null) {
			res--;

			if (res == 0) {
				break;
			}
			temp = temp.next;
		}

		temp.next = temp.next.next;

		return head;
	}

	// TC: O(n)
	// SC: O(1)
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		// fast will point to the (n-1)^th node position

		// base case if n^th node is the first node
		if (fast == null) {
			return head.next;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		// changing last link from (n-1)th node pos.
		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
