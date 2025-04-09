package org.leetcode.gfg.aditya.verma.revision;

import java.util.*;

public class NextSmallerToRight {

	// TC: O(n)
	// SC: O(n)
	public static List<Integer> nextSmallerElement(List<Integer> arr, int n) {
		Stack<Integer> st = new Stack<>();
		List<Integer> list = new ArrayList<>();
		// initially push the last element into stack
		st.push(arr.get(n - 1));
		// for last element there is no one at the right side
		list.add(-1);
		for (int i = n - 2; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() >= arr.get(i)) {
				st.pop();
			}
			//smaller element is left only & present at the top, if and only if stack is not empty.
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
		List<Integer> arr = Arrays.asList(6, 2, 5, 4, 5, 1, 6);
		List<Integer> result = nextSmallerElement(arr, arr.size());
		System.out.println(result);

	}

}
