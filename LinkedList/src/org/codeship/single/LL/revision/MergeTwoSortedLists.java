package org.codeship.single.LL.revision;

public class MergeTwoSortedLists {

	// TC: O(n)
	// SC: O(1)
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
		// if t1 or t2 is exhausted
		if (t1 != null) {
			temp.next = t1;
		} else if (t2 != null) {
			temp.next = t2;
		}
		return dummyNode.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
