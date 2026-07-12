package org.string.easy.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
	
	//TC: O(m) | m is the average length of longest prefix b/w first & last character
    //SC: O(m)
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        //sort the string & compare b/w first & last String only for prefix match
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minLen = Math.min(first.length(), last.length());
        for(int i = 0; i < minLen; i++) {
            if(first.charAt(i) == last.charAt(i)) {
                sb.append(first.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
