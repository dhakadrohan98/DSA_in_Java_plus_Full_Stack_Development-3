package org.codeship.single.LL;

public class DetectALoopSLL {

	public boolean hasCycle(ListNode head) {

		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
