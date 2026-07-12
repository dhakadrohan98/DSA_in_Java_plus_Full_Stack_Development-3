package org.string.easy.leetcode;

import java.util.*;

public class RemoveOuterMostParenthesis {
	// TC: O(n)
	// SC: O(n)
	public String removeOuterParentheses(String s) {
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				st.push(ch);
				if (st.size() > 1) { //this is not outermost opening parenthesis, 
					//already one opening parenthesis is present inside stack
					sb.append(ch);
				}
			} else {
				st.pop();
				if (!st.isEmpty()) {
					//popped out parenthesis is not the outermost one
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
