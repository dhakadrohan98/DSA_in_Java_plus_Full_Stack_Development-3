package org.recursion;

public class PrintFromNto1 {

	static int N = 5;
	
	public static void printFromNto1() {
		//base case
		if(N <= 0) {
			return;
		}
		//Forwarding steps
		System.out.println(N);
		N = N - 1;
		printFromNto1();
	}
	
	public static void printThroughBackTrack(int n) {
		//base case
		if(n >= 6) {
			return;
		}
		
		printThroughBackTrack(n + 1); //f(4) -> f(5) -> f(6) -> f(5) -> f(4) -> exit
		//backtrack steps
		System.out.println(n);
		
	}
	
	
	public static void main(String[] args) {
		printThroughBackTrack(4);
		System.out.println();
		
//		printThroughBackTrack(1);
	}

}
