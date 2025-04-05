package org.codeship.single.LL.revision;

public class ReverseLinkedListInGroupOfSizeK {
	
	// TC: O(n) reverse whole linked list + O(n) get kthNode in each group
	// SC: O(1)
	public ListNode getKthNode(ListNode temp, int k) {
		k -= 1;
		while (temp != null && k > 0) {
			k -= 1;
			temp = temp.next;
		}
		return temp;
	}

	public ListNode reverseList(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode curr = head;
		ListNode nextt = head.next;
		while (nextt != null) {
			curr.next = prev;
			prev = curr;
			curr = nextt;
			nextt = nextt.next;
		}
		curr.next = prev;
		return curr;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode temp = head;
		ListNode prevList = null;

		while (temp != null) {
			ListNode kthNode = getKthNode(temp, k);
			// given linked lists size is less than
			if (kthNode == null) {
				// last group which is not of size k
				if (prevList != null) {
					prevList.next = temp;
				}
				break;
			}
			// keep track of nextNode
			ListNode nextNode = kthNode.next;
			// detach linked list of size k to reverse it
			kthNode.next = null;
			reverseList(temp);
			// it is a first group
			if (temp == head) {
				head = kthNode;
			} else {
				prevList.next = kthNode;
			}

			// keep track of prevNode or prevList & nextNode
			prevList = temp;
			temp = nextNode;
		}
		return head;
	}
}
