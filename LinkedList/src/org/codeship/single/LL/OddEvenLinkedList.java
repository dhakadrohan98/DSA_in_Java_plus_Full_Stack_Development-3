package org.codeship.single.LL;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		// TC: O(n)
		// SC: O(n)
		// if list is empty
		if (head == null) {
			return head;
		}
		// Node having one or two node only
		if (head.next == null || head.next.next == null) {
			return head;
		}

		ListNode temp = head;
		List<Integer> list = new ArrayList<>();

		while (temp != null && temp.next != null) {
			list.add(temp.val);
			temp = temp.next.next;
		}
		if (temp != null) {
			list.add(temp.val);
		}

		ListNode temp1 = head.next;
		while (temp1 != null && temp1.next != null) {
			list.add(temp1.val);
			temp1 = temp1.next.next;
		}
		if (temp1 != null) {
			list.add(temp1.val);
		}

		int i = 0;
		temp = head;

		while (temp != null && i < list.size()) {
			temp.val = list.get(i);
			i++;
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
