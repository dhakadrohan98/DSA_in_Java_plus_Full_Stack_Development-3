package org.codeship;

import java.util.Scanner;

public class GCDOfTwoNumbers {

	
	public static int recGcd(int a, int b) {
		//base case
		if(b==0) return a;
		return recGcd(b, a%b);
	}
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / recGcd(a, b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));

	}

}
