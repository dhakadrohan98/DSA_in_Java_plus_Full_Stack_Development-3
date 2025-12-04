package org.cp.numbertheory;

import java.util.Scanner;

public class NCK_Combinations_	 {

	/*
	 * M is a large prime M > n
	 */
	static final int M = (int) 1e9 + 7; // PRIME
	static final int N = (int) 10e7 + 10; // Max
	static int[] fact = new int[N];

	// Binary exponentiation: a^b % M
	private static int binExpItr(long a, long b) {
		long ans = 1;
		a %= M;
		while (b > 0) {
			if ((b & 1) != 0) {
				ans = (ans * a) % M;
			}
			a = (a * a) % M;
			b = (b >> 1);
		}
		return (int) ans;
	}

	// Apply fermet little theorem
	/*
	 * A^(M-1) ~= 1 mod M where M is a prime number and A is not multilple of M =>
	 * A^(M-2) = (A^-1) mod M => ( A^(M-2) ) % M = A^-1
	 */
	public static int nCk(int n, int k) {
		if (k < 0 || k > n) {
			return 0;
		}
		long numerator = fact[n];
		long denominator = (fact[k] * 1l * fact[n - k]) % M;
		int inv = binExpItr(denominator, M - 2);
		return (int) ((numerator * inv) % M);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// precompute factorial of N numbers for Q queries
		fact[0] = 1;
		for (int i = 1; i < N; i++) {
			fact[i] = (int) (fact[i - 1] * 1l * i) % M;
		}
		System.out.println("Fact of 1 to 6: ");
		// print factorial till 6
		for (int i = 1; i < 7; i++) {
			System.out.print(fact[i] + " ");
		}
		System.out.println();

		int q = sc.nextInt();
		while (q-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(nCk(n, k));
		}
	}

}
