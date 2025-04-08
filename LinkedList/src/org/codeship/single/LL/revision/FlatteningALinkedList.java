package org.codeship.single.LL.revision;

class Node2 {

	int data;
	Node2 next;
	Node2 child;

	public Node2(int data) {
		super();
		this.data = data;
		this.next = null;
		this.child = null;
	}

}

public class FlatteningALinkedList {

	// TC: O(N) * O(2m) due to merge function
	// SC: O(N) recursion stack space

	// TC: O(n1 + n2) = O(m + m) = O(2m)
	// merge two lists vertically
	private Node2 merge(Node2 list1, Node2 list2) {
		Node2 dummyNode = new Node2(-1);
		Node2 temp = dummyNode;
		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				temp.child = list1;
				temp = list1;
				list1 = list1.child;
			} else {
				temp.child = list2;
				temp = list2;
				list2 = list2.child;
			}
		}
		// list1 or list2 nodes are remaining
		if (list1 != null) {
			temp.child = list1;
		} else {
			temp.child = list2;
		}
		// dummyNode.child -> head of two merged list;
		// set null to the next of head of two merged list
		dummyNode.child.next = null;
		return dummyNode.child;
	}

	// Function to flatten a linked list
	// use the concept of merge two sorted lists (a little changed here is
	// vertically wise)
	// Then apply recursion pick the last two list & merge it & then return its head
	// then again pick the current list & mergedLists and merge it & return
	// mergedHead
	// follow similar pattern until all lists are merged together & return the
	// updated
	// head at the end
	public Node2 flatten(Node2 head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		// recursive call for next list
		Node2 mergedHead = flatten(head.next);
		head = merge(head, mergedHead);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
