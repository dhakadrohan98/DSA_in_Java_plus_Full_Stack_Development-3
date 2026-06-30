package org.string.leetcode.mediumProblems.revision3;

import java.util.*;

public class SortCharactersByFrequency {

	//TC: O(n*logn)
	//SC: O(n)
	public static String frequencySort(String s) {
		Map<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}
		// sort hashmap based on values in decreasing order
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(hmap.entrySet());
		Collections.sort(list, (a,b) -> b.getValue() - a.getValue()); //sort map in decreasing order based on values
		Map<Character, Integer> lhmap = new LinkedHashMap<>();
		for(Map.Entry<Character, Integer> element: list) {
			lhmap.put(element.getKey(), element.getValue());
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : lhmap.keySet()) {
			while(lhmap.get(ch) != 0) {
				sb.append(ch);
				lhmap.put(ch, lhmap.get(ch) - 1);
			}
		}
		return sb.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans = frequencySort("ccjciajakai");
		System.out.println(ans);

	}

}
