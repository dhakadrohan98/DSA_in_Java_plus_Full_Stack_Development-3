package org.cp.binarsearch;

import java.util.Scanner;

public class NthRootOfElement {

	static double epislon = 1e-3;

	public static double multiply(double mid, int n) {
		double ans = 1.0;
		for(int i = 1; i <=n; i++) {	
			ans *= mid;
		}
		return ans;
	}
	
	//TC - P(multiplying numbers from 1 to n) * (N * log(10^d)) | d- precision value for decimal number
	public static void NthRoot(double x, int n) {
		double low = 1.0, high = x;
		while((high - low) > epislon) {
			double mid = (high + low) /2 ;
			if(multiply(mid, n) < x) {
				low = mid;
			} else {
				high = mid;
			}
		}
		System.out.printf("%dth root value: %.3f%n",n, high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double x = sc.nextDouble();
		NthRoot(x, n);

	}

}
