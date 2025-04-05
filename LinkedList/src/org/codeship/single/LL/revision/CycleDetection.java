package org.codeship.single.LL.revision;

public class CycleDetection {

	// TC: O(n)
	// SC: O(1)
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
