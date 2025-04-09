package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

public class RemoveKDigits {
	
	//remove k bigger digits
	public static String removeKdigits(String num, int k) {
		int n = num.length();
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			char ch = num.charAt(i);
			//if top digit of stack is greater than current digit
			while(!st.isEmpty() && k > 0 && (st.peek() - '0') > (ch - '0')) {
				st.pop();
				k -= 1;
			}
			st.push(ch);
		}
		// str = "123456", k=3
		while(k > 0) {
			st.pop();
			k--;
		}
		//if all digits are removed from the string according to k value & st became empty then return "0" as ans
		if(st.isEmpty()) {
			return "0";
		}
		StringBuilder res = new StringBuilder();
		while(!st.isEmpty()) {
			res.append(st.pop());
		}
		//edge cases
		//with leading zeroes
		//00001432219
		System.out.println(res);
		while(res.length()!= 0 && res.charAt(res.length() - 1) == '0') {
			res = res.deleteCharAt(res.length() - 1);
		}
		//reverse the sb
		String finalRes = res.reverse().toString();
		//again check if res has become empty or not
		if(finalRes.isEmpty()) {
			return "0";
		}
		return finalRes;
	}
	
	public static void main(String[] args) {
		String num = "00001432219";
		int k = 3;
		System.out.println(removeKdigits(num, k));

	}

}
