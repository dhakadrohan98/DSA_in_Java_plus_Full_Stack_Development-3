package org.codeship.single.LL;

public class AddOneToANumberRepresentedAsLinkedList {

	private class Node {
		
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static int helper(Node temp) {
		// base case
		if (temp == null) {
			return 1; // returning carry for the first time
		}
		// recursive call
		int carry = helper(temp.next);
		// logic(after went deepen through recursive call) when backtracking starts
		temp.data = temp.data + carry;

		if (temp.data < 10) {
			return 0;
		} else {
			// temp.data > 9
			temp.data = 0;
			return 1;
		}
	}

	public static Node addOne(Node head) {
		int carry = helper(head);

		if (carry == 1) {
			Node newNode = new Node(1);
			newNode.next = head;
			return newNode;
		}
		// if carry is not 1, the no need to create a new node, simply return head
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
