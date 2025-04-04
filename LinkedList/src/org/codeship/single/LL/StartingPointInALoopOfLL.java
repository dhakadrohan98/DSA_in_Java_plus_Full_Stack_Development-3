package org.codeship.single.LL;

public class StartingPointInALoopOfLL {

	public ListNode detectCycle(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		boolean hasLoop = false;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				hasLoop = true;
				break;
			}
		}

		if (hasLoop) {
			ListNode temp = head;

			while (temp != fast) {
				temp = temp.next;
				fast = fast.next;
			}
			return temp;
		} else {
			return null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
