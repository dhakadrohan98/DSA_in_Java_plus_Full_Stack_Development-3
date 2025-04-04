package org.codeship.single.LL;

public class SortTwoLinkedList {

	// Modified tortoise & hear algorithm to find middle of the node
	public static ListNode findMiddle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// merge two sorted list algorithm
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode t1 = list1;
		ListNode t2 = list2;
		ListNode dummyNode = new ListNode(-1);
		ListNode temp = dummyNode;

		while (t1 != null && t2 != null) {
			if (t1.val < t2.val) {
				temp.next = t1;
				temp = t1;
				t1 = t1.next;
			} else {
				temp.next = t2;
				temp = t2;
				t2 = t2.next;
			}
		}

		if (t1 != null) {
			temp.next = t1;
		} else {
			temp.next = t2;
		}

		return dummyNode.next;
	}

	public ListNode sortList(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}

		ListNode middle = findMiddle(head);
		ListNode leftHead = head;
		ListNode rightHead = middle.next;
		// separate the right half list
		middle.next = null;

		leftHead = sortList(leftHead);
		rightHead = sortList(rightHead);

		return mergeTwoLists(leftHead, rightHead);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
