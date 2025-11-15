package org.cp.binarsearch;

import java.util.Scanner;

public class SquareRootOf_Upto3DecimalPlaces {

	static double epislon = 1e-3;
	
	public static void sqrt(double x) {
		double low = 1.0, high = x;
		while((high - low) > epislon) {
			double mid = (high + low) /2 ;
			if(mid * mid < x) {
				low = mid;
			} else {
				high = mid;
			}
		}
		System.out.printf("Sqrt value: %.3f%n", high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		sqrt(x);
	}

}
