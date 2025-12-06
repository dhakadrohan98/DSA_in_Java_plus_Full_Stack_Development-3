package com.recursion.revision3;

import java.util.*;

public class LetterCombinationOfPhoneNumber {

	// TC: O(2^l) -> l=length of largest single digit
	// SC: O(length of digits)
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Map<Character, String> hmap = new HashMap<>();
		hmap.put('2', "abc");
		hmap.put('3', "def");
		hmap.put('4', "ghi");
		hmap.put('5', "jkl");
		hmap.put('6', "mno");
		hmap.put('7', "pqrs");
		hmap.put('8', "tuv");
		hmap.put('9', "wxyz");
		func(0, digits, ans, hmap, sb);
		return ans;
	}

	private void func(int indx, String digits, List<String> ans, Map<Character, String> hmap, StringBuilder sb) {
		// base case
		if (indx == digits.length()) {
			ans.add(sb.toString());
			return;
		}

		String letters = hmap.get(digits.charAt(indx));
		for (int k = 0; k < letters.length(); k++) {
			sb.append(letters.charAt(k));
			func(indx + 1, digits, ans, hmap, sb);
			// backtracking steps
			sb.deleteCharAt(sb.length() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
