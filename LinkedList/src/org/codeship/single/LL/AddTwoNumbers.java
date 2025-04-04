package org.codeship.single.LL;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummyNode = new ListNode(-1);
		ListNode curr = dummyNode;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		int carry = 0;

		while (temp1 != null || temp2 != null) {

			int sum = carry;

			if (temp1 != null)
				sum += temp1.val;
			if (temp2 != null)
				sum += temp2.val;

			ListNode newNode = new ListNode(sum % 10); // keep val into newNode
			carry = sum / 10;

			curr.next = newNode;
			curr = curr.next;

			if (temp1 != null)
				temp1 = temp1.next;
			if (temp2 != null)
				temp2 = temp2.next;
		}

		if (carry == 1) {
			ListNode newNode = new ListNode(carry);
			curr.next = newNode;
			curr = curr.next;
		}

		return dummyNode.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
