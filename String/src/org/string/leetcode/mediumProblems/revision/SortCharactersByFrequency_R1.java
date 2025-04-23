package org.string.leetcode.mediumProblems.revision;

import java.util.*;

public class SortCharactersByFrequency_R1 {
	
	class Pair {
		char ch;
		int freq;

		public Pair(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

    public String frequencySort(String s) {
        //sort the hasmap based on values
        Map<Character, Integer> hmap = new HashMap<>();
		for(char ch : s.toCharArray()) {
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }

		List<Pair> list = new ArrayList<>();
		for (Map.Entry<Character, Integer> map : hmap.entrySet()) {
			char ch = map.getKey();
			int freq = map.getValue();
			list.add(new Pair(ch, freq));
		}
		
		Collections.sort(list, (p1, p2) -> p2.freq - p1.freq);
		Map<Character, Integer> lmap = new LinkedHashMap<>();
		for(Pair p : list) {
			lmap.put(p.ch, p.freq);
		}
        StringBuilder sb = new StringBuilder();
        for(char ch : lmap.keySet()) {
            int freq = lmap.get(ch);
            while(freq-- > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
