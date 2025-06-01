package org.string.leetcode.mediumProblems.revision2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharactersByFrequency {

	// TC: O(2n) + O(n*logn)
	// SC: O(2n)
	public static String frequencySort(String s) {
		Map<Character, Integer> hmap = new HashMap<>();
		for (char ch : s.toCharArray()) {
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(hmap.entrySet());
		Collections.sort(list, (c1, c2) -> c2.getValue() - c1.getValue());
		Map<Character, Integer> lhmap = new LinkedHashMap<>();
		for (Map.Entry<Character, Integer> map : list) {
			lhmap.put(map.getKey(), map.getValue());
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : lhmap.keySet()) {
			int val = lhmap.get(ch);
			while (val-- > 0) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "tree";
		System.out.println(frequencySort(str));

	}

}
