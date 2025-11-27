package org.cp.numbertheory;

public class SuperPow_EulerTotientFunction {

	//TC: O(n) = O(logn) where n is length of b array
	//SC: O(1)
	private static int binExpItr(int a, int b) {
		int M = 1337;
		a = a % M;
		int ans = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				ans = (int) ((ans * a * 1l) % M);
			}
			a = (int) ((a * a * 1l) % M);
			b = (b >> 1);
		}
		return ans;
	}

	public static int superPow(int a, int[] b) {
		// M = 1140 (Euler totient function is applied on 1337 = 191 * 7)
		int M = 1140;
		int n = b.length;
		int mul = 1;
		int B = 0;
		// build the number from b[] array
		//Math - nerd nerd nerd...
		//x * 10^3 + y * 10^2 + z * 10^1
		for (int i = n - 1; i >= 0; i--) {
			B = B + ((mul * b[i]) % M);
			mul = (mul * 10) % M;
		}
		// While binExpItr, use M = 1337, do not use phi(1337)
		return binExpItr(a, B);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
