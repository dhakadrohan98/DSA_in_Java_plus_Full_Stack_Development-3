package org.cp.numbertheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HighestLowestPrimeNumber_1ToN {

	static int M = (int) (10e7 + 10);
	static boolean[] isPrime = new boolean[M];
	static int[] lp = new int[M];
	static int[] hp = new int[M];

	// TC: O(n * log(log(n)))
	// SC: O(1)
	public static void getLowest_HighestPrime(int n) {
		// mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < n; i++) {
			if (isPrime[i] == true) {
				// mark hp & lp same for prime number itself
				lp[i] = hp[i] = i;
				for (int j = i * 2; j < n; j += i) {
					isPrime[j] = false;
					// mark highest prime for number - j, it will replace with subsequent
					// encountered prime numbers to keep track
					// of highest one
					hp[j] = i;
					// mark lowest prime for j first time only
					if (lp[j] == 0) {
						lp[j] = i;
					}
				}
			}
		}
		
		System.out.println("\n" + "Enter a number to know its all prime factors");

		// find prime factorization through highest prime of given num
		int num = new Scanner(System.in).nextInt();
		List<Integer> primeFacList = new ArrayList<>();
		HashMap<Integer, Integer> hmap = new HashMap<>();

		//calculate prime factors from its highest prime number
		//TC: O(Q * logn)
		while (num > 1) {
			int prime_factor = hp[num];
			while (num % prime_factor == 0) {
				//store count of prime_factors
				hmap.put(prime_factor, hmap.getOrDefault(prime_factor, 0) + 1);
				num = num / prime_factor;
				primeFacList.add(prime_factor);
			}
		}
		// print prime factor list
		System.out.println(primeFacList);
		System.out.println();
		System.out.println(hmap);

		// print lowest & highest prime numbers for 1 to 100
		for (int i = 1; i <= 100; i++) {
			System.out.println("i - " + i + " lp: " + lp[i] + " hp: " + hp[i]);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		getLowest_HighestPrime(n);

	}

}
