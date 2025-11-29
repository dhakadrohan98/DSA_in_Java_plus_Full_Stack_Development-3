package org.cp.numbertheory;

import java.util.Scanner;

public class CountAndSumOfFactors_N {

	// Q.1) for Q queries, count the all divisors of n & sum it up, we need technique which can give count & sum in constant time
	// What is 10^14 <= n <= n^18, will this algo in 1 sec ?
	// TC: O(sqrt(n))
	public static void sqrtMethod(int n) {
		int cnt = 0;
		int sum = 0;
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				cnt += 1;
				sum += i;
				//to avoid duplicate pair calculation when n is perfect of square of any number.
				if (n / i != i) {
					cnt += 1;
					sum += (n / i);
				}
			}
		}
		System.out.println("Count of factors - " + cnt);
		System.out.println("Sum of factors - " + sum);
	}

	// TC: O(n)
	public static void countSumfactorsBruteForce(int n) {
		int cnt = 0;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				cnt += 1;
				sum += i;
			}
		}
		System.out.println("Count of factors - " + cnt);
		System.out.println("Sum of factors - " + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Brute force calculation");
		countSumfactorsBruteForce(n);
		System.out.println("Sqrt method calculation");
		sqrtMethod(n);

	}

}
