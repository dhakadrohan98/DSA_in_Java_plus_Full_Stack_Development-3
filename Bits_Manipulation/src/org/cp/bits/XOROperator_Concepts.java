package org.cp.bits;

public class XOROperator_Concepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//swap 2 numbers
		int a = 4;
		int b = 7;
		a = a ^ b;
		b = a ^ b; // b = (a ^ b) ^ b = a
		a = b ^ a; // a = a ^ (a ^ b) = b
		System.out.println("b - " + b);
		System.out.println("a - " + a);
	}

}
