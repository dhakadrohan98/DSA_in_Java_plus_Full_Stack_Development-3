package org.string.leetcode.mediumProblems.revision2;

import java.util.LinkedHashMap;
import java.util.Map;

public class SecondMostFrequentCharacter {

	private static char findSecondMostFreqChar(String s) {
		char res = ' ';
		Map<Character, Integer> lhmap = new LinkedHashMap<>();
		for (char ch : s.toCharArray()) {
			if(ch == ' ') continue;
			lhmap.put(ch, lhmap.getOrDefault(ch, 0) + 1);
		}
		System.out.println(lhmap);
		
		int largest = 0;
		int secondLargest = 0;
		for (char key : lhmap.keySet()) {
			int val = lhmap.get(key);
			if (largest < val) {
				secondLargest = largest;
				largest = val;
			}

			if (val < largest && secondLargest < val) {
				secondLargest = val;
			}
		}

		for (char key : lhmap.keySet()) {
			if (lhmap.get(key) == secondLargest) {
				res = key;
				break;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String s = "programming languages";
		char secondMostFreqChar = findSecondMostFreqChar(s);
		System.out.println(secondMostFreqChar);
	}

}
