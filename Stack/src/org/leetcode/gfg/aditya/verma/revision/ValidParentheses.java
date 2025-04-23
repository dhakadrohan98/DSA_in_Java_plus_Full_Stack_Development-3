package org.leetcode.gfg.aditya.verma.revision;

import java.util.*;

public class ValidParentheses {

	// TC: O(n)
	// SC: O(n)
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i++);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (!st.isEmpty()) {
				if (ch == ')' && st.peek() != '(') {
					return false;
				} else if (ch == '}' && st.peek() != '{') {
					return false;
				} else if (ch == ']' && st.peek() != '[') {
					return false;
				}
				st.pop();
			} else {
				st.push(ch);
			}
		}
		// if stack is not empty we did not find all parentheses as valid parentheses
		if (!st.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
