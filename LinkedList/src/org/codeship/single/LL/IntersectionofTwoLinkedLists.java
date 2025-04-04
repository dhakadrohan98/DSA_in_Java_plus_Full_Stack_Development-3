package org.codeship.single.LL;

import java.util.HashMap;
import java.util.Map;

public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode temp1 = headA;
		ListNode temp2 = headB;

		// base case
		if ((headA == null || headA.next == null) && (headB == null || headB.next == null)) {
			if (headA == headB) {
				return headA;
			} else {
				return null;
			}
		}

		Map<ListNode, ListNode> hmap1 = new HashMap<>();
		Map<ListNode, ListNode> hmap2 = new HashMap<>();

		// main logic
		while (temp1 != null && temp2 != null) {
			// checking node at first list
			if (!hmap1.containsKey(temp1) && !hmap2.containsKey(temp1)) {
				hmap1.put(temp1, temp1.next);
				temp1 = temp1.next;
			} else {
				return temp1;
			}
			// checking node at second list
			if (!hmap2.containsKey(temp2) && !hmap1.containsKey(temp2)) {
				hmap2.put(temp2, temp2.next);
				temp2 = temp2.next;
			} else {
				return temp2;
			}
		}

		// if any of temp1 or temp2 has been exhausted
		if (temp1 != null) {
			while (temp1 != null) {
				if (!hmap1.containsKey(temp1) && !hmap2.containsKey(temp1)) {
					hmap1.put(temp1, temp1.next);
					temp1 = temp1.next;
				} else {
					return temp1;
				}
			}
		} else {
			while (temp2 != null) {
				if (!hmap2.containsKey(temp2) && !hmap1.containsKey(temp2)) {
					hmap2.put(temp2, temp2.next);
					temp2 = temp2.next;
				} else {
					return temp2;
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
