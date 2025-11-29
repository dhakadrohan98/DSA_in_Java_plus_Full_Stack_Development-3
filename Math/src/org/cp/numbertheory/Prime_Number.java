package org.cp.numbertheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime_Number {

	public static List<Integer> primeFactorsMethod_Optimized(int n) {
		List<Integer> ans = new ArrayList<>();
		// i <= Math.sqrt(n);
		// i * i <= n
		for (int i = 2; i * i <= n; i++) {
			// 36/2 -> 18/2 -> 9
			// 9/3 -> 3/3 -> 1
			while (n % i == 0) {
				ans.add(i);
				n = (n / i);
			}
		}
		// if last prime numbers remains to divide in case of when last factor has
		// last_prime_factor^1
		if (n > 1) {
			ans.add(n);
		}
		return ans;
	}

	// TC: O(sqrt(n))
	// SC: O(1)
	public static void primeCheckSqrtMethod(int n) {
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println("not a prime");
				return;
			}
		}
		System.out.println("N was a prime number");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		primeCheckSqrtMethod(n);
		System.out.println("primeFactors of " + n + " are - ");
		List<Integer> primeFactorsMethod = primeFactorsMethod_Optimized(n);
		for (int itr : primeFactorsMethod) {
			System.out.print(itr + " ");
		}
	}

}
