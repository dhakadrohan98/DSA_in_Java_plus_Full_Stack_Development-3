package com.recusrion.striver;

public class Recursion1 {

	static int count = 0;
	public static void print() {
		
		//base condition
		if(count == 3) {
			return;
		}
		System.out.println(count);
		count++;
		print();
		
	}
	
	public static void main(String[] args) {
		print();
	}

}
