package com.recusrion.revision;

public class _1ToNusingBacktracking {

	public static void rec(int x, int n) {
		//base case
		//TC: O(2n)
		//SC: O(n) stack space
		if(x < 1) {
			return;
		}
		rec(x-1, n);
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		int n = 5;
		rec(n, n);
	}

}
