package com.codeship.medium.revision3;

import java.util.*;

//TC: O(n*m)
//SC: O(1)
public class SpiralMatrix {

	//n-rows, m-columns
	public List<Integer> spiralOrder(int[][] mat) {
		List<Integer> ans = new ArrayList<>();
		int n = mat.length;
		int m = mat[0].length;
		int rs = 0;
		int re = n-1;
		int cs = 0;
		int ce = m-1;
		
		while(rs <= re && cs <= ce) {
			//1. traverse row from left to right, rs coordinate is constant
			for(int j = cs; j <= ce; j++) {
				ans.add(mat[rs][j]);
			}
			rs += 1;
			
			//2. traverse column from top to down, ce coordinate is constant
			if(rs <= re && cs <= ce) {
				for(int i = rs; i <= re; i++) {
					ans.add(mat[i][ce]);
				}
				ce -= 1;
			} else {
				break;
			}
			
			//3. traverse row from right to left, re coordinate is constant
			if(rs <= re && cs <= ce) {
				for(int j = ce; j >= cs; j--) {
					ans.add(mat[re][j]);
				}
				re -= 1;
			} else {
				break;
			}
			
			//4. traverse column from bottom to up, cs coordinate is constant
			if(rs <= re && cs <= ce) {
				for(int i = re; i >= rs; i--) {
					ans.add(mat[i][cs]);
				}
				cs += 1;
			} else {
				break;
			}
			
		}
		
		
		return ans;
    }
	
	
	public static void main(String[] args) {

	}

}
