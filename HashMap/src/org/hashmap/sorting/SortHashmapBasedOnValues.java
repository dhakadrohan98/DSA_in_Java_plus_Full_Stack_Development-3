package org.hashmap.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//✅ Approach (Correct & Common)
//🔹 Steps
//Convert entrySet() to a List
//Sort the list using Collections.sort() with a lambda comparator
//Put entries into a LinkedHashMap to preserve order

public class SortHashmapBasedOnValues {

	static class Pair {

		char ch;
		int freq;

		public Pair(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

	public static void main(String[] args) {
		Map<Character, Integer> hmap = new HashMap<>();
		hmap.put('t', 1);
		hmap.put('r', 3);
		hmap.put('e', 2);

		List<Pair> list = new ArrayList<>();
		for (Map.Entry<Character, Integer> map : hmap.entrySet()) {
			char ch = map.getKey();
			int freq = map.getValue();
			list.add(new Pair(ch, freq));
		}
		Collections.sort(list, (p1, p2) -> {
			return p2.freq - p1.freq;
		});
		Map<Character, Integer> lhmap = new LinkedHashMap<>();
		for (Pair p : list) {
			lhmap.put(p.ch, p.freq);
		}
		System.out.println(lhmap);
		System.out.println();
		for (char ch : lhmap.keySet()) {
			System.out.print(ch + ", ");
		}

	}

}
