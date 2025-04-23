package com.recusrion.revision;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
	
	private void rec(int indx, StringBuilder sb, String digits, String[] str, List<String> ans) {
        //base case
        if(indx == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        //50 - 48 = 2
        int num = digits.charAt(indx) - '0';
        String s = str[num];
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            rec(indx + 1, sb, digits, str, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }


    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        //if empty string
        if(digits.length() == 0) {
            return ans;
        }
        String[] str = new String[10];
        str[0] = "";
        str[1] = "";
        str[2] = "abc";
        str[3] = "def";
        str[4] = "ghi";
        str[5] = "jkl";
        str[6] = "mno";
        str[7] = "pqrs";
        str[8] = "tuv";
        str[9] = "wxyz";
        StringBuilder sb = new StringBuilder();
        rec(0, sb, digits, str, ans);
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
