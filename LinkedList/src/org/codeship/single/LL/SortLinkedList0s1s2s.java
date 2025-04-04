package org.codeship.single.LL;

public class SortLinkedList0s1s2s {

	class Node {
		public int data;
		public Node next;

		Node() {
			this.data = 0;
			this.next = null;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public static Node findMiddle(Node head) {

		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// merge two sorted list algorithm
	public static Node mergeTwoLists(Node list1, Node list2) {

		Node t1 = list1;
		Node t2 = list2;
		Node dummyNode = new Node(-1);
		Node temp = dummyNode;

		while (t1 != null && t2 != null) {
			if (t1.data < t2.data) {
				temp.next = t1;
				temp = t1;
				t1 = t1.next;
			} else {
				temp.next = t2;
				temp = t2;
				t2 = t2.next;
			}
		}

		if (t1 != null) {
			temp.next = t1;
		} else {
			temp.next = t2;
		}

		return dummyNode.next;
	}

	public static Node sortList(Node head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}

		Node middle = findMiddle(head);
		Node leftHead = head;
		Node rightHead = middle.next;
		// separate the right half list
		middle.next = null;

		leftHead = sortList(leftHead);
		rightHead = sortList(rightHead);

		return mergeTwoLists(leftHead, rightHead);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
