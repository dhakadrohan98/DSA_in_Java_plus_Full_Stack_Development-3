package com.recusrion.revision;

import java.util.*;

public class PalindromePartitioning {

	// TC: O(2^n) * O(n)
	// SC: O(n)
	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<>();
		List<String> path = new ArrayList<>();
		func(0, s, path, ans);
		return ans;
	}

	private void func(int indx, String s, List<String> path, List<List<String>> ans) {
		// base case
		if (indx == s.length()) {
			ans.add(new ArrayList<>(path));
			return;
		}

		for (int i = indx; i < s.length(); i++) {
			if (isPalindrome(s, indx, i)) {
				path.add(s.substring(indx, i + 1));
				func(i + 1, s, path, ans);
				path.remove(path.size() - 1);
			}
		}
		return;
	}

	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
