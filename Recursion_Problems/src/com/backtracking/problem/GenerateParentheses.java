package com.backtracking.problem;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	//TC -
	//Aux space - O(2n) n -> number of of opening/closing brackets
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(sb, n, n, res);
        return res;
    }

    //ro - remaining opening & remaining closing
    void generate(StringBuilder sb, int ro, int rc, List<String> res) {
        //base case
        if(ro == 0 &&  rc == 0) {
            res.add(sb.toString());
            return;
        }
        //call to the left subtree
        if(ro > 0) {
            sb.append('(');
            generate(sb, ro-1, rc, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(rc > 0) {
            if(ro < rc) { //uo > uc
                sb.append(')');
                generate(sb, ro, rc-1, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
