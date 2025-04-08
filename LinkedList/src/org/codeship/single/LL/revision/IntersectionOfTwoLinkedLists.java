package org.codeship.single.LL.revision;

public class IntersectionOfTwoLinkedLists {

	// TC: O(2n)
	// SC: O(1)
	private int findLength(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode head1 = headA;
		ListNode head2 = headB;
		// if length of any linked list is greater then take the head pointer of that
		// list
		// to next node until length of both list are matched
		int len1 = findLength(headA);
		int len2 = findLength(headB);
		while (len1 > len2) {
			head1 = head1.next;
			len1 -= 1;
		}
		while (len2 > len1) {
			head2 = head2.next;
			len2 -= 1;
		}
		while (head1 != null & head2 != null && head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
