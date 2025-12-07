package payu.linkedlist;

class ListNode {

	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}

public class MergeTwoSortedList {

	// TC: O(n)
	// SC: O(1)
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// edge case
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else if (list1 == null && list2 == null) {
			return null;
		}
		ListNode dummyNode = new ListNode(-1);
		ListNode temp = dummyNode;
		ListNode t1 = list1;
		ListNode t2 = list2;
		while (t1 != null && t2 != null) {
			if (t1.val <= t2.val) {
				temp.next = t1;
				temp = t1;
				t1 = t1.next;
			} else {
				temp.next = t2;
				temp = t2;
				t2 = t2.next;
			}
		}
		while (t1 != null) {
			temp.next = t1;
			temp = t1;
			t1 = t1.next;
		}
		while (t2 != null) {
			temp.next = t2;
			temp = t2;
			t2 = t2.next;
		}
		return dummyNode.next;
	}

}
