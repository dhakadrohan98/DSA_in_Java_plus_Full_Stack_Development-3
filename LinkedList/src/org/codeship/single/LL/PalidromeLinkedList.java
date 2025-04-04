package org.codeship.single.LL;

public class PalidromeLinkedList {

	public ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {

			if (fast.next.next == null) {
				fast = fast.next.next;
			} else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return slow;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode prev = null;
		ListNode curr = head;
		ListNode ahead = null;

		while (curr != null) {
			ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		head = prev;

		return head;
	}

	public boolean isPalindrome(ListNode head) {
		ListNode midNode = middleNode(head);
		ListNode secondHalf = midNode.next;

		ListNode temp = head;
		ListNode temp2 = reverseList(secondHalf);

		while (temp != null && temp2 != null) {

			if (temp.val != temp2.val) {
				return false;
			}
			temp = temp.next;
			temp2 = temp2.next;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
