package org.codeship.single.LL.revision;

public class NthNodeFromTheEnd {

	// TC: O(2n)
	// SC: O(1)
	public static Node nthNodeFromEnd(Node head, int n) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		// position from the starting
		int startPos = count - n;
		temp = head;
		while (startPos > 0 && temp != null) {
			startPos -= 1;
			temp = temp.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
