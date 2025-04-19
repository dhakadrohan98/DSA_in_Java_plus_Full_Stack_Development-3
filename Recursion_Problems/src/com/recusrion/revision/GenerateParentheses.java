package com.recusrion.revision;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	//TC: O(2^n)
	//SC: O(n) recursive tree
	private void helper(List<String> ans, int n, int oc, int cc, String str) {
        //base case
        if(oc == n && cc == n) {
            ans.add(str);
            return;
        }

        if(oc < n) {
            helper(ans, n, oc + 1, cc, str+"(");
        }

        if(cc < oc) {
            helper(ans, n, oc, cc + 1, str+")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int oc = 0, cc = 0;
        helper(ans, n, oc, cc, "");
        return ans;
    }
}
