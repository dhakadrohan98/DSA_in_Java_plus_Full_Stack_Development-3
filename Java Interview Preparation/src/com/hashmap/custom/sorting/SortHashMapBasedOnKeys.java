package com.hashmap.custom.sorting;

import java.util.*;

public class SortHashMapBasedOnKeys {

	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("first", 1);
		hmap.put("a", 3);
		hmap.put("z", 4);
		hmap.put("r", 2);
		System.out.println(hmap);
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(hmap.entrySet());
		Map<String, Integer> lhmap = new LinkedHashMap<>();
		//sort elements based on keys in the reverse lexicographically order
		Collections.sort(list, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
		
		//sort elements based on values in the reverse lexicographically order
		Collections.sort(list, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
		
		for(Map.Entry<String, Integer> map : list) {
			lhmap.put(map.getKey(), map.getValue());
		}
		System.out.println(lhmap);
		
	}

}
