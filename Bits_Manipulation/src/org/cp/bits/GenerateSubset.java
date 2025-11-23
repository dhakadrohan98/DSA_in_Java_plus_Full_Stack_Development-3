package org.cp.bits;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateSubset {

	//Bit masking concept is used
    //TC: O(2^n * n)
    //SC: O(1)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+10];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		//calculations starts here
		List<List<Integer>> subsets = new ArrayList<>();
		int subset_cnt = 1 << n; // subset_cnt = 2^n;
		//mask = 0,1,2,3,-----,(2^n - 1)
		for(int mask = 0; mask < subset_cnt; mask++) {
			
			List<Integer> subset = new ArrayList<>();
			//i=0,1,2
			for(int i = 0; i < n; i++) {
				if((mask & (1 << i)) != 0) {
					subset.add(arr[i]);
				}
			}
			subsets.add(subset);
		}
		
		//print the subset
		for(List<Integer> subList : subsets) {
			System.out.println(subList);
		}

	}

}
