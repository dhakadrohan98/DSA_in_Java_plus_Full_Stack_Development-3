package org.codeship.single.LL.revision;

public class OddEvenLinkedList_ExtraSpace {
	// TC: O(n)
	// SC: O(n) avoid this extra space
	public ListNode oddEvenList(ListNode head) {
		// edge cases
		if (head == null || head.next == null) {
			return head;
		}

		ListNode temp = head;
		int indx = 1;
		ListNode odd = new ListNode(-1);
		ListNode temp1 = odd;
		ListNode even = new ListNode(-1);
		ListNode temp2 = even;
		while (temp != null) {
			// odd index
			if (indx % 2 != 0) {
				ListNode newNode = new ListNode(temp.val);
				// updating head first time
				if (indx == 1) {
					odd.next = newNode;
					odd = newNode;
				}
				temp1.next = newNode;
				temp1 = newNode;
			} else {
				ListNode newNode = new ListNode(temp.val);
				// updating head second time
				if (indx == 2) {
					even.next = newNode;
					even = newNode;
				}
				temp2.next = newNode;
				temp2 = newNode;
			}
			temp = temp.next;
			indx += 1;
		}
		// Attach the odd index linked list's last node with head of even index linked
		// list
		temp1.next = even;
		return odd;
	}
}
