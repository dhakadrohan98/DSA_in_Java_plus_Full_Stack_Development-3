package org.cp.numbertheory;

public class BinaryExponentiation {

	private static final int M = 12;
	
	//TC: O(logb) base to 2
	//SC: O(logb) depth of recursion
	public static long binaryExpRec(int a, int b) {
		//if a is large, it may overflow before taking %M 
		a %= M;
		//base case
		if(b == 0) return 1;
		
		long res = binaryExpRec(a, b/2);
		//b is odd
		if((b&1) != 0) {
			return (a * ((res * 1l * res) % M)) % M;
		} else {
			return (res * 1l * res) % M;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2, b =13;
		int ans = 1;
		for(int i = 0; i < b; i++) {
			ans *= a;
			ans %= M;
		}
		System.out.println(ans);
		System.out.println();
		
		System.out.println(binaryExpRec(a,b));
	}

}
