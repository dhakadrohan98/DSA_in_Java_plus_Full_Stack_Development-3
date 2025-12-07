package payu.linkedlist;

public class CycleDetection {

	// TC: O(n)
	// SC: O(n)
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			slow = slow.next;
			if (fast != null && fast.next != null) {
				fast = fast.next.next;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
