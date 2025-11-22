package org.cp.bits;

import java.util.Scanner;

public class BinaryNumber_6_different_Tricks {

	public static void printBinary(int num) {
		for(int i = 10; i >= 0; i--) {
			//num >> i - basically ith bit ko 0th position pr le jaa rha hn
			System.out.print(((num>>i) & 1) + " ");
		}
		System.out.println();
	}
	
	public static void clearIthLSBBits(int num, int i) {
		//original binary num
		printBinary(num);
		
		int ans = num & (~((1 << i+1)-1));
		printBinary(ans);
		return;
	}
	
	public static void clearIth_MSBBits(int num, int i) {
		//original binary num
		printBinary(num);
		
		int ans = num & ((1 << i+1)-1);
		printBinary(ans);
		return;
	}
	
	public static boolean powerOf2(int num) {
		if((num & (num-1)) == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i = sc.nextInt();
		
//		System.out.println("Clear i^th MSB from right to left");
//		clearIthLSBBits(num, i);
//		System.out.println();
		
		System.out.println("power of 2 check-");
		System.out.println(powerOf2(num));
		System.out.println();
		
		
		System.out.println("Clear i^th MSB from left to right");
		clearIth_MSBBits(num, i);
		System.out.println();
		
		System.out.println("printing character's binary");
		for(char ch='A'; ch <= 'E'; ch++) {
			System.out.println(ch);
			printBinary(ch);
		}
		
		for(char ch='a'; ch <= 'e'; ch++) {
			System.out.println(ch);
			printBinary(ch);
		}
		System.out.println();
		//concept: If i want to convert uppercase ‘A’ into lowercase ‘a’ then i have to set 5th position bit of 
		//corresponding uppercase letter.
		char upperA = 'A';
		//set the 5th bit of single uppercase character to convert it into lowercase characters
		char lowerA = (char) (upperA | (1 << 5));
		System.out.println(lowerA);
		//unset the 5th bit of single lowercase character to convert it into uppercase characters
		System.out.println((char) (lowerA & (~(1 << 5))));
		
		//One more observation (LC -> UC and UC -> LC)
		//if any uppercase letter binary is taken or with space(' ') character then uppercase gets converted into lowercase char.
		System.out.println();
		char upperZ = 'Z';
		System.out.println((char) (upperZ | ' '));
		
		System.out.println();
		char lowerX = 'x';
		//if any lowercase letter binary taken and with underscore('_') character then lowercase gets converted into uppercase char.
		System.out.println((char) (lowerX & '_'));

	}

}
