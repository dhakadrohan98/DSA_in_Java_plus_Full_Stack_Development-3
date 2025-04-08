package org.leetcode.gfg.aditya.verma.revision;

import java.util.*;

public class NextSmallerToRight {

	// TC: O(n)
	// SC: O(n)
	public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		// initially push the last element into stack
		st.push(arr.get(n - 1));
		// for last element there is no one at the right side
		list.add(-1);
		for (int i = n - 2; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() >= arr.get(i)) {
				st.pop();
			}
			// smaller element is left at the top if stack is not empty
			if (!st.isEmpty()) {
				list.add(st.peek());
			} else {
				list.add(-1);
			}
			st.push(arr.get(i));
		}
		Collections.reverse(list);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
