package org.codeship.single.LL.revision;

public class RemoveDuplicatesFromSortedList {

	// TC: O(n)
	// SC: O(1)
	public ListNode deleteDuplicates(ListNode head) {
		ListNode prev = head;
		ListNode curr = null;
		// edge cases when no. of node is 0 or 1
		if (prev != null) {
			curr = prev.next;
		}

		while (prev != null && curr != null) {
			if (prev.val == curr.val) {
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
