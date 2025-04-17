package com.recusrion.revision;

public class PowXToN {
	
	//TC: O(2n) 2 pass
	//SC: O(n) stack space
	public static int pow(int x,int n) {
		//base case
		if(n < 1) {
			return 1;
		}
		
		int res = x * pow(x, n-1);
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(pow(5, 3));
	}

}
