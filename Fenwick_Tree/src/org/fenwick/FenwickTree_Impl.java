package org.fenwick;

import java.util.Scanner;

public class FenwickTree_Impl {

	static int n = (int)10e5;
	static int N = (int) 10e5 + 7;
	static int[] fen = new int[N];
	
	//TC: O(logn)
	//SC: O(n) less than segment tree where SC: O(4*n)
	public static void update(int i, int add) {
		while(i < n) {
			fen[i] += add;
			i = i + (i & (-i));
		}
	}
	
	//TC: O(logn)
	public static int sum(int i) {
		int sum = 0;
		while(i > 0) {
			sum += fen[i];
			i = i - (i & (-i));
		}
		return sum;
	}
	
	//TC: O(2*logn)
	public static int rangeSum(int l, int r) {
		return sum(r) - sum(l-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size + 3];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1; i < size; i++) {
			update(i, arr[i]);
		}
		
		System.out.println(sum(13));
		System.out.println(sum(14));
		System.out.println(sum(15));
		System.out.println(sum(16));

	}

}

/*
17
0 1 0 2 1 1 3 0 4 2 5 2 2 3 1 0 2
 * 
 * 
 */
