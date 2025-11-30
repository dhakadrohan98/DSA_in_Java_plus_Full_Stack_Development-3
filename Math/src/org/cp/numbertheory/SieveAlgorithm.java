package org.cp.numbertheory;

import java.util.Arrays;
import java.util.Scanner;

public class SieveAlgorithm {

	static int M = (int) (10e7 + 10);
	static boolean[] isPrime = new boolean[M];

	// TC: O(n * log(log(n)))
	// SC: O(1)
	// (n/2 + n/3 + n/4 + n/5+ ------------+ n/n) for all 1 <= n <= ~infinite
	// n (1/2 + 1/3 + 1/4 + 1/5) ==== N * log(N)

	// (1/2 + 1/3 + n/5+ ------------) for all n are prime numbers only
	// n (1/2 + 1/3 + 1/4 + 1/5) ==== N * log(log(N))
	public static void isPrime_SieveAlgo(int n) {
		// mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// print prime numbers
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				System.out.print(i + " ");
			}
		}
		return;
	}

	// outer for loop calculation variation - for(int i = 2; i * i < n; i++)
	public static void isPrime_SieveAlgo_Optimize1(int n) {
		// mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i < n; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		// print prime numbers
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				System.out.print(i + " ");
			}
		}
		return;
	}

	// inner for loop calculation variation - for(int j = i * i; j <= n; j += i)
	// this algo has included n also in the ans list
	public static void isPrime_SieveAlgo_Optimize2(int n) {
		// mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		// print prime numbers
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				System.out.print(i + " ");
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		isPrime_SieveAlgo(n);
		System.out.println();
		isPrime_SieveAlgo_Optimize1(n);
		System.out.println();
		isPrime_SieveAlgo_Optimize2(n);

	}

}
