package org.recursion;

public class FactorialOfN {
	
	static int fact = 1;
	
	public static int factorial(int n) {
		//base case
		if(n == 1) {
			return 1;
		}
		return n * factorial(n-1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
	}

}
