package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

public class PostfixEvaluation {

	public int evaluate(String[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			String s = arr[i];
			if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("*")) {
				int num2 = st.pop();
				int num1 = st.pop();
				if (s.equals("*")) {
					st.push(num1 * num2);
				} else if (s.equals("/")) {
					st.push(num1 / num2);
				} else if (s.equals("+")) {
					st.push(num1 + num2);
				} else {
					st.push(num1 - num2);
				}
			}
			// ch is not operand push it into the stack
			else {
				st.push(Integer.parseInt(s));
			}
		}
		return st.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
