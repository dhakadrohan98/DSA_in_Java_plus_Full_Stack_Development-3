package org.codemonk._2DPrefixSum;

import java.util.Iterator;
import java.util.Scanner;

public class _GCDOfArrayElementsExcept_LtoR_GCDQ_Codechef {

	static final int N = 10^5;
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	
	//TC: O(T * O(n * logn) * O(Q) ) ~ 10^6
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[] arr = new int[n+10];
			for(int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
			}
			//compute forward & backward gcd - pre computation
			int[] forward = new int[n+10];
			int[] backward = new int[n+10];
			//gcd(x,0) = x;
			forward[0] = backward[n] = 0;
			
			//forward gcd computation
			for(int i = 1; i <= n; i++) {
				forward[i] = gcd(forward[i-1], arr[i]);
			}
			
			//backward gcd computation
			for(int i = n; i >= 1; i--) {
				backward[i] = gcd(backward[i+1], arr[i]);
			}
			
			//let answer for q queries in O(1) tc
			while(q-- > 0) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				System.out.println(gcd(forward[l-1], backward[r+1]));
			}
		}
	}

}
