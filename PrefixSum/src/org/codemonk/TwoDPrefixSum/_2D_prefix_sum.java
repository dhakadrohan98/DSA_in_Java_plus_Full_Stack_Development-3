package org.codemonk.TwoDPrefixSum;

import java.util.Scanner;

public class _2D_prefix_sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//take inputs
		int N = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] pSum = new int[N+1][N+1]; 
		//calculate 2d prefix sum
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				pSum[i][j] = arr[i][j] + pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1];
			}
		}
		int q = sc.nextInt();
		while(q-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			long res = pSum[c][d] - pSum[a-1][d] - pSum[c][b-1] + pSum[a-1][b-1];
			System.out.println(res);
		}

	}

}
