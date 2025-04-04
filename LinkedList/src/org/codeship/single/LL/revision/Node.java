package org.codeship.single.LL.revision;

public class Node {

	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

	public static Node addLast(Node head, int data) {
		// base case
		if (head == null) {
			return head;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node last = new Node(data);
		temp.next = last;
		return head;
	}

	public Node add(Node head, int x, int y) {
		// base case
		if (head == null) {
			return head;
		}

		Node extra = new Node(y);
		Node temp = head;

		while (temp.data != x) {
			temp = temp.next;
		}

		Node temp2 = temp.next;
		temp.next = extra;
		extra.next = temp2;

		return head;
	}

}
