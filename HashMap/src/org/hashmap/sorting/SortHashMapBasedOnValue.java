package org.hashmap.sorting;

import java.util.*;

public class SortHashMapBasedOnValue {

	public static void main(String[] args) {
		Map<String, Integer> dietMap  = new HashMap<>();
		dietMap.put("Chicken Breast (100g)", 165);
		dietMap.put("Egg (1)", 70);
		dietMap.put("Paneer (100g)", 265);
		dietMap.put("Tofu (100g)", 144);
		dietMap.put("Milk (250ml)", 150);
		dietMap.put("Curd (100g)", 98);
		dietMap.put("Greek Yogurt (100g)", 59);
		dietMap.put("Oats (100g)", 389);
		dietMap.put("Brown Rice (100g)", 111);
		dietMap.put("White Rice (100g)", 130);
		dietMap.put("Chapati (1)", 120);
		dietMap.put("Sweet Potato (100g)", 86);
		dietMap.put("Potato (100g)", 77);
		dietMap.put("Banana (1)", 105);
		dietMap.put("Apple (1)", 95);
		dietMap.put("Orange (1)", 62);
		dietMap.put("Mango (100g)", 60);
		dietMap.put("Broccoli (100g)", 34);
		dietMap.put("Spinach (100g)", 23);
		dietMap.put("Carrot (100g)", 41);
		dietMap.put("Cucumber (100g)", 16);
		dietMap.put("Tomato (100g)", 18);
		dietMap.put("Almonds (100g)", 579);
		dietMap.put("Cashews (100g)", 553);
		dietMap.put("Walnuts (100g)", 654);
		dietMap.put("Peanuts (100g)", 567);
		dietMap.put("Peanut Butter (100g)", 588);
		dietMap.put("Olive Oil (100ml)", 884);
		dietMap.put("Butter (100g)", 717);
		dietMap.put("Cheese (100g)", 402);
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(dietMap.entrySet());
		Collections.sort(list, (map1, map2) -> map2.getValue() - map1.getValue());
		LinkedHashMap<String, Integer> lhmap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> map : list) {
			lhmap.put(map.getKey(), map.getValue());
		}
		
		for(String key : lhmap.keySet()) {
			System.out.println(key + " -> " + lhmap.get(key));
		}
		

	}

}
