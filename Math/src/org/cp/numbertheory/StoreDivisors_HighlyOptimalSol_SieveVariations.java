package org.cp.numbertheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StoreDivisors_HighlyOptimalSol_SieveVariations {

	static int N = (int) (10e5 + 10);
	static boolean[] isPrime = new boolean[N];

	// TC: O(N * logN)
	public static void getLowest_HighestPrime() {
		// mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		ArrayList<Integer>[] divisors = (ArrayList<Integer>[]) new ArrayList[N];

		for (int i = 0; i < N; i++) {
			divisors[i] = new ArrayList<Integer>();
		}
		
		// TC: O(N * logN)
		for (int i = 2; i < N; i++) {
			for (int j = i; j < N; j += i) {
				divisors[j].add(i);
			}
		}

		for (int i = 1; i <= 10; i++) {
			System.out.print("i: " + i + "-> ");
			for (int num : divisors[i]) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		getLowest_HighestPrime();

	}

}
