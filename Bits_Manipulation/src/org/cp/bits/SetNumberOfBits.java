package org.cp.bits;

import java.util.Scanner;

import org.bits.manipulation.CountSetBits;

public class SetNumberOfBits {

	
	public static void printBinary(int num) {
		for(int i = 10; i >= 0; i--) {
			//num >> i - basically ith bit ko 0th position pr le jaa rha hn
			System.out.print(((num>>i) & 1) + " ");
		}
		System.out.println();
	}
	
	public static void checkSetBit(int num, int i) {
		if((num & (1<<i)) != 0) {
			System.out.println("set bit");
		} else {
			System.out.println("unset bit");
		}
	}
	
	public static void countSetBits(int num) {
		int cnt = 0;
		for(int i = 31; i >= 0; i--) {
			if((num & (1<<i)) != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	
	public static void main(String[] args) {
//		Integer a = (1 << 31);
//		//shiftAmount = 32 % 32 = 0
//		System.out.println(a);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
//		Integer b = (1 << 31) - 1;
//		System.out.println(b);
		
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//		int i = sc.nextInt();
		printBinary(num);
//		checkSetBit(num, i);
		
		/*
		 * set ith bit
		 */
//		System.out.println("set i^th bit");
//		int setbit = num | (1 << i);
//		printBinary(setbit);
		
		/*
		 * unset ith bit
		 */
//		System.out.println("unset ith bit");
//		int unsetbit = num & (~(1 << i));
//		printBinary(unsetbit);
		
		//toggle a bit
//		printBinary(num ^ (1 << i));
		
		//count set bit
		countSetBits(num);
		
		System.out.println(Integer.bitCount(num));
		//count set bits in Long number
		System.out.println(Long.bitCount((1l << 35)));
		System.out.println(Long.bitCount((1l << 35) - 1));
		
	}

}
