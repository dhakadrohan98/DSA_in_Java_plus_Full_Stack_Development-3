package org.cp.numbertheory;

public class BinaryExponentiationIterative {

	// TC: O(logb) base to the 2.
	//M = 10e9+7 (a prime number)
	static int M = (int) 1e9 + 7;

	private static int binExpItr(int a, int b) {
		int ans = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				ans = (int) (ans * a * 1l) % M;
			}
			a = (int) (a * a * 1l) % M;
			b = (b >> 1);
		}
		return ans;
	}

	// a is very very large <= 10^18 or a = 2^1024;
	// a <= 10^18 or a = 2^1024, b <= 10^9 and M <= 10^9
	private static int binExpItr_aIsVeyLarge(int a, int b) {
		a %= M;
		// or
		a = binExpItr(2, 1024);
		int ans = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				ans = (int) (ans * a * 1l) % M;
			}
			a = (int) (a * a * 1l) % M;
			b = (b >> 1);
		}
		return ans;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------

	// M is very very large <= 10^18
	// a <= 10^9, b <= 10^9 and M <= 10^18
	private static int binMultiply_mIsVeryLarge(int a, int b) {
		int ans = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				ans = (ans + a) % M;
			}
			a = (a + a) % M;
			b = (b >> 1);
		}
		return ans;
	}

	// a <= 10^9, b <= 10^9 and M <= 10^18
	private static int binMultiply_mIsVeryLarge_ParentCall(int a, int b) {
		int ans = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				ans = binMultiply_mIsVeryLarge(ans, a);
			}
			a = binMultiply_mIsVeryLarge(a, a);
			b = (b >> 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 21313, b = 23123;
		System.out.println(binExpItr(a, b));
		System.out.println(Math.pow(a, b));
	}

}
