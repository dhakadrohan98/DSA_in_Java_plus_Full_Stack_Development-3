package org.string.leetcode.mediumProblems.revision;

import java.util.*;

public class SortCharactersByFrequency_HmapValueSorting {

	// TC: O(3n * logn)
	// SC: O(2n)
	public String frequencySort(String s) {
		Map<Character, Integer> hmap = new HashMap<>();
		for (char ch : s.toCharArray()) {
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(hmap.entrySet());
		Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
		Map<Character, Integer> lhmap = new LinkedHashMap<>();
		for (Map.Entry<Character, Integer> map : list) {
			lhmap.put(map.getKey(), map.getValue());
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : lhmap.keySet()) {
			int freq = lhmap.get(ch);
			while (freq-- > 0) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
