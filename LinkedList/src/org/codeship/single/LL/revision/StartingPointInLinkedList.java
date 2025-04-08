package org.codeship.single.LL.revision;

public class StartingPointInLinkedList {
	// TC:O(n*k)
	// SC: O(1)
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean hasLoop = false;
		// hasLoop method
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasLoop = true;
				break;
			}
		}
		ListNode temp = head;
		if (hasLoop) {
			while (temp != fast) {
				temp = temp.next;
				fast = fast.next;
			}
			return temp;
		}
		// no cycle or loop is found
		return null;
	}
}
