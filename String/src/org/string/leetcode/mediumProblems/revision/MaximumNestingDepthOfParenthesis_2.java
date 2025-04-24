package org.string.leetcode.mediumProblems.revision;

import java.util.Stack;

public class MaximumNestingDepthOfParenthesis_2 {
	
	//TC: O(n)
    //SC: O(n)
    public int maxDepth(String s) {
        int n = s.length();
        Stack st = new Stack<>();
        int max = 0;
        int currCount = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
                currCount += 1;
                max = Math.max(max, currCount);
            }
            else if(ch == ')') {
                if(!st.isEmpty()) {
                    st.pop();
                    currCount -= 1;
                }
            }
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
