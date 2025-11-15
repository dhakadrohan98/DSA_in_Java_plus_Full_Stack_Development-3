package org.cp.binarsearch;

import java.util.Scanner;

public class RequiredHeightTreeForWoodCutting {

	//Global declaration of variables
	static final long N = (long) (10e6+10); // N- number of trees 1 <= N <= 10^6
	static int n = 0;
	static long m = 0;
	//Global declaration of arrays if array size is > 10^5
	static long[] trees = new long[(int) N];
	
	//monotonic predicate function
	//base on height of the tree
	//T T T T T T T F F F F F F F 
	public static boolean isWoodSufficient(long height) {
		long woods = 0;
		for(int i = 0; i < n; i++) {
			if(trees[i] >= height) {
				woods += (trees[i] - height);
			}
		}
		return woods >= m;
	}
	
	public static void getMaxHeightOfTrees() {
		//low - cut from the ground level
		//high -> 1 000 000 000, the heights of each tree (in metres)
		long low = 0, high = (long) 1e9;
		//T T T T T T F F F F F
		while(high - low > 1) {
			long mid = (low + high) / 2;
			if(isWoodSufficient(mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		if(isWoodSufficient(high)) {
			System.out.println(high);
		} else {
			System.out.println(low);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextLong();
		
		for(int i = 0; i < n; i++) {
			trees[i] = sc.nextLong();
		}
		getMaxHeightOfTrees();
		
	}

}
