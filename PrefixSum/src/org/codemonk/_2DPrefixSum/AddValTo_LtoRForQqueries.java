package org.codemonk._2DPrefixSum;

import java.util.Scanner;

//TC - O(q) + O(2n) ~ O(n) ~ 10^7 (acceptable in 1 sec)
public class AddValTo_LtoRForQqueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		long[] arr = new long[n+10];
		long max = -1;
		while(q-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long k = sc.nextInt();
			//difference array sum propagates
			arr[a] += k;
			arr[b+1] -= k;
		}
		//build the prefix sum array
		for(int i = 1; i <= n; i++) {
			arr[i] += arr[i-1];
		}
		//find the maximum
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, arr[i]);
		}
		System.out.println(max);
	}

}
