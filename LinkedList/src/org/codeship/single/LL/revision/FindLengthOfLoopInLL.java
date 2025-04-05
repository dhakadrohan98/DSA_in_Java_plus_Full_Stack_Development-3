package org.codeship.single.LL.revision;

import java.util.*;

public class FindLengthOfLoopInLL {
	// TC: O(2n)
	// SC: O(n)
	// Function to find the length of a loop in the linked list.
	public int countNodesinLoop(Node head) {
		Node slow = head;
		Node fast = head;
		boolean hasLoop = false;
		// hasLoop method
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasLoop = true;
				break;
			}
		}

		int ans = 0;
		Map<Node, Integer> hmap = new HashMap<>();
		Node temp = head;
		if (hasLoop) {
			int indx = 0;
			while (!hmap.containsKey(temp)) {
				hmap.put(temp, indx++);
				temp = temp.next;
			}
			int index = hmap.get(temp);
			ans = hmap.size() - index;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
