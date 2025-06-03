package org.string.leetcode.mediumProblems.revision;

import java.util.*;
import java.util.Map.Entry;

public class SecondMostFrequentCharacter {
	
	//TC: O(n)
	//SC: O(n)
	private static char findSecondMostFreqChar_OptimizedApproach(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char ch : s.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}

		char firstMaxChar = ' ', secondMaxChar = ' ';
		int firstMaxFreq = 0, secondMaxFreq = 0;

		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			int freq = entry.getValue();
			char ch = entry.getKey();

			if (freq > firstMaxFreq) {
				secondMaxFreq = firstMaxFreq;
				secondMaxChar = firstMaxChar;

				firstMaxFreq = freq;
				firstMaxChar = ch;
			} else if (freq > secondMaxFreq || (freq == secondMaxFreq && ch < secondMaxChar)) {
				secondMaxFreq = freq;
				secondMaxChar = ch;
			}
		}

		return secondMaxChar;
	}

	// TC: O(n logn) + O(n)
	// SC: O(2n) extra space
	private static char findSecondMostFreqChar_BruteForceApproach(String s) {
		Map<Character, Integer> hmap = new HashMap<>();
		for (char ch : s.toCharArray()) {
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(hmap.entrySet());
		// sort the map based on frequency of characters in descending order, if
		// frequency of two character are equals then sort
		// them in lexicographically order
		Collections.sort(list, (e1, e2) -> {
			if (e1.getValue() == e2.getValue()) {
				return e1.getKey().compareTo(e2.getKey());
			}
			return Integer.compare(e2.getValue(), e1.getValue());
		});
		Map<Character, Integer> lhmap = new LinkedHashMap<>();
		for (Map.Entry<Character, Integer> map : list) {
			lhmap.put(map.getKey(), map.getValue());
		}

		char ch = ' ';
		int count = 1;
		for (char key : lhmap.keySet()) {
			if (count == 2) {
				return key;
			}
			count++;
		}
		return ch;
	}

	public static void main(String[] args) {
		String s = "programming languages";
		char secondMostFreqChar = findSecondMostFreqChar_OptimizedApproach(s);
		System.out.println(secondMostFreqChar);
	}

}
