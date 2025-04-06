package org.codeship.single.LL.revision;

import java.util.*;

public class MergeKSortedLists {

	class Pair {
		int val;
		ListNode node;

		Pair(int val, ListNode node) {
			this.val = val;
			this.node = node;
		}
	}

	// TC: O(k logk) + O(n * k * 2* logk)
		// SC: O(k) due to nodes in pq
		// pq<int, ListNode>
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		// O(k logk)
		for (int i = 0; i < k; i++) {
			ListNode head = lists[i];
			if (head != null) {
				pq.offer(new Pair(head.val, head));
			}
		}
		ListNode dNode = new ListNode(-1);
		ListNode temp = dNode;
		// O(n * logk)
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			temp.next = p.node;
			if (p.node.next != null) {
				pq.offer(new Pair(p.node.next.val, p.node.next));
			}
			// move temp from prev node to next attached node
			temp = temp.next;
		}
		// head of merged list
		return dNode.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
