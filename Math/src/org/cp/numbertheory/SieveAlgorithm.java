package org.cp.numbertheory;

import java.util.Arrays;
import java.util.Scanner;

public class SieveAlgorithm {
	
	static int M = (int) (10e7+10);
	static boolean[] isPrime = new boolean[M];
	
	//TC: O(n * log(log(n)))
	//SC: O(1)
	public static void isPrime_SieveAlgo(int n) {
		//mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2; i < n; i++) {
			for(int j = i*2; j <= n; j += i) {
				isPrime[j] = false; 
			}
		}
		//print prime numbers
		for(int i = 2; i <= n; i++) {
			if(isPrime[i]) {
				System.out.print(i + " ");
			}
		}
		return;
	}
	
	public static void isPrime_SieveAlgo_Optimize1(int n) {
		//mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2; i * i < n; i++) {
			for(int j = i*2; j <= n; j += i) {
				isPrime[j] = false; 
			}
		}
		//print prime numbers
		for(int i = 2; i <= n; i++) {
			if(isPrime[i]) {
				System.out.print(i + " ");
			}
		}
		return;
	}
	
	//this algo has included n also in the ans list
	public static void isPrime_SieveAlgo_Optimize2(int n) {
		//mark all number with true initially
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2; i < n; i++) {
			for(int j = i*i; j < n; j += i) {
				isPrime[j] = false; 
			}
		}
		//print prime numbers
		for(int i = 2; i <= n; i++) {
			if(isPrime[i]) {
				System.out.print(i + " ");
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		isPrime_SieveAlgo(n);
		System.out.println();
		isPrime_SieveAlgo_Optimize1(n);
		System.out.println();
		isPrime_SieveAlgo_Optimize2(n);

	}

}
