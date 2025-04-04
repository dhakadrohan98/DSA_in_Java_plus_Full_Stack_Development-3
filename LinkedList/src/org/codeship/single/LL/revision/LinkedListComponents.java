package org.codeship.single.LL.revision;

import java.util.*;

public class LinkedListComponents {
	// Tc: O(n)
	// SC: O(1)
	public int numComponents(ListNode head, int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		int components = 0;
		ListNode curr = head;

		while (curr != null) {
			if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) {
				components++;
			}
			curr = curr.next;
		}

		return components;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
