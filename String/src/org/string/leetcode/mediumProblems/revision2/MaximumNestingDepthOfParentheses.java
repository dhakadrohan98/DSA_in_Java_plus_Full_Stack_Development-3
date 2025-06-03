package org.string.leetcode.mediumProblems.revision2;

import java.util.Stack;

public class MaximumNestingDepthOfParentheses {
	
	//TC: O(n)
	//SC: O(n)
	public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int maxi = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                st.push(ch);
                maxi = Math.max(maxi, st.size());
            } else if(ch == ')') {
                st.pop();
            }
        }
        return maxi;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
