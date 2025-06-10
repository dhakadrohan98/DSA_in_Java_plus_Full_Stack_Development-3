package org.stack.easyproblems;

import java.util.*;

public class ValidParentheses {

	// TC: O(n)
	// SC: O(n)
	public boolean isValid(String s) {
		int n = s.length();
		Stack<Character> st = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (!st.isEmpty()) {
				// ch are equals to any one of the following - ), } & ]
				char top = st.pop();
				if (ch == ')' && top != '(') {
					return false;
				} else if (ch == '}' && top != '{') {
					return false;
				} else if (ch == ']' && top != '[') {
					return false;
				}
			} else { // first ch of new pair can be from ), } & ]
				return false;
			}
		}
		if (st.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
