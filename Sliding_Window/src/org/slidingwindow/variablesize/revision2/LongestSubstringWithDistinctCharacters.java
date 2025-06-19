package org.slidingwindow.variablesize.revision2;

import java.util.*;

public class LongestSubstringWithDistinctCharacters {
	
	//TC: O(n)
    //SC: O(k)
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        Map<Character, Integer> hmap = new HashMap<>();
        int i = 0, j = 0;
        int longest = 0;
        while(j < n) {
            char ch = s.charAt(j);
            //do some calculations
            // Add character to map
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1); 
        
            while(hmap.get(ch) > 1) {
                //remove calculation for repeating character from left side
                        char ch1 = s.charAt(i);
                        hmap.put(ch1, hmap.get(ch1) - 1);
                        i++;
                }
                // Update longest after ensuring no duplicates
                longest = Math.max(longest, j - i + 1);
                j++;
        }
        return longest;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
