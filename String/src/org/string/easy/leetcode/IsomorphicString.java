package org.string.easy.leetcode;

import java.util.*;

public class IsomorphicString {
	
	public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> hmap1 = new HashMap<>();
        Map<Character, Character> hmap2 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            char mappedChar = '.';
            if(hmap1.containsKey(ch1)) {
                mappedChar = hmap1.get(ch1);
                if(mappedChar != ch2) {
                    return false;
                }
            } else if(hmap2.containsKey(ch2)) {
                mappedChar = hmap2.get(ch2);
                if(mappedChar != ch1) {
                    return false;
                }
            }
            if(!hmap1.containsKey(ch1)) {
                hmap1.put(ch1, ch2);
            }
            if(!hmap2.containsKey(ch2)) {
                hmap2.put(ch2, ch1);
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
