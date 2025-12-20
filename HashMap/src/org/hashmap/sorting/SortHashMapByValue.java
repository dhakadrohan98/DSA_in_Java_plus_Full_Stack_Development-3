package org.hashmap.sorting;

import java.util.*;

public class SortHashMapByValue {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("A", 3);
		map.put("B", 1);
		map.put("C", 2);

		// Step 1: Convert entrySet to List
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

		// Step 2: Sort using lambda comparator (by value)
		Collections.sort(entryList, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));

		// Step 3: Preserve order using LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : entryList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		System.out.println(sortedMap);
	}
}
