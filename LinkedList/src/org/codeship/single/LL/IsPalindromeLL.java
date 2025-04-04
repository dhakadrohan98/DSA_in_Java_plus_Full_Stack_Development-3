package org.codeship.single.LL;

import java.util.Stack;
import java.util.Vector;

public class IsPalindromeLL {

	public static boolean isPalindrome(ListNode head) {

		ListNode temp = head;
		Stack<Integer> st = new Stack();

		// push all elements into the stack
		while (temp != null) {
			st.push(temp.val);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			int value = st.pop();
			if (temp.val != value) {
				return false;
			}
			temp = temp.next;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
