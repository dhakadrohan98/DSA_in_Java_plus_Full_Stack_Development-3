package com.recusrion.revision;

import java.util.*;

public class PrintAllSubsequencesOfAString {
	// TC: O(2^n)
	// SC: O(n) stack space
	public List<String> AllPossibleStrings(String s) {
		// Code here
		List<String> ans = new ArrayList<>();
		int n = s.length();
		String str = "";
		rec(0, s, str, ans);
		return ans;
	}

	private void rec(int indx, String original, String str, List<String> ans) {
		// base case
		if (indx >= original.length()) {
			ans.add(str);
			return;
		}

		// include current character
		rec(indx + 1, original, str + original.charAt(indx), ans);
		// not include
		rec(indx + 1, original, str, ans);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
