package com.backtracking.problem;

import java.util.Scanner;

public class FindOddCountElement {

	// TC: O(n)
	// SC: O(1) if we use hash array or hashmap then its SC-O(n) which is
	// constraints here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 10];
		// xor property -> a ^ a = 0
		// a ^ 0 = a
		int ans = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			ans ^= arr[i];
		}

		System.out.println(ans);

	}

}

// i/p:
//13
//2 4 6 7 7 4 2 2 2 6 6 5 6
// o/p- 5
