package org.codeship.single.LL.revision;

import java.util.HashSet;
import java.util.Set;

//14_57 test cases are passed
public class LinkedListComponents_PartialTestCasesPassed {

	// TC: O(n)
	// SC: O(1)
	public int numComponents(ListNode head, int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		// edge cases
		// list had 1 node only
		if (head != null && head.next == null) {
			return 1;
		}
		ListNode curr = head;
		ListNode nextt = curr.next;
		int components = 0;
		while (nextt != null) {
			boolean isComponent = false;
			while (nextt != null && set.contains(curr.val) && set.contains(nextt.val)) {
				isComponent = true;
				nextt = nextt.next;
			}
			if (isComponent) {
				components += 1;
			}
			curr = nextt;
			if (nextt != null) {
				nextt = nextt.next;
			}
		}

		// last node as alone component
		if (curr != null && set.contains(curr.val)) {
			components += 1;
		}
		return components;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
