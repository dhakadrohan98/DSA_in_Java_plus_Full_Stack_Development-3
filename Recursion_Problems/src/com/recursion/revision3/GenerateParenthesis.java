package com.recursion.revision3;

import java.util.*;

public class GenerateParenthesis {

	List<String> ans = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		int op = 0;
		int cp = 0;
		rec(op, cp, n, sb);
		return ans;
	}

	private void rec(int op, int cp, int n, StringBuilder sb) {
		// base case
		if (op == n && cp == n) {
			ans.add(sb.toString());
			return;
		}

		if (op < n) {
			// add op
			sb.append('(');
			rec(op + 1, cp, n, sb);
			// while backtrack-- remove last added parenthesis from sb
			sb.deleteCharAt(sb.length() - 1);
		}

		if (cp < n) {
			if (cp < op) {
				sb.append(')');
				rec(op, cp + 1, n, sb);
				// while backtrack-- remove last added parenthesis from sb
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
