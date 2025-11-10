package com.codemonk;

import java.util.Scanner;

public class MergeSortAlgo {

	//Global declaration of array
	static final int n = (int) 1e5;
	static int[] arr = new int[n+10];
	
	public static void merge(int l, int r, int mid) {
		int l_size = mid - l + 1;
		int r_size = r - mid;
		int[] L = new int[l_size+1];
		int[] R = new int[r_size+1];
		//construct the left array
		for(int i = 0; i < l_size; i++) {
			L[i] = arr[l+i];
		}
		//construct the right array
		for(int i = 0; i < r_size; i++) {
			R[i] = arr[mid+1+i];
		}
		//little tricky if any of the left/right side array value exhausted then elements of other array will be compared 
		//with max value of exhausted array side. No extra conditions are required
		L[l_size] = R[r_size] = Integer.MAX_VALUE;
		int l_i = 0;
		int r_i = 0;
		//merge both arrays from l to r indexes
		for(int i = l; i <= r; i++) {
			if(L[l_i] <= R[r_i]) {
				arr[i] = L[l_i];
				l_i++;
			} else {
				arr[i] = R[r_i];
				r_i++;
			}
		}
	}
	
	public static void mergeSort(int l, int r) {
		//base case
		if(l==r) return;
		
		int mid = (l + r) / 2;
		mergeSort(l, mid);
		mergeSort(mid+1, r);
		merge(l, r, mid);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(0, size-1);
		//print the array
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}

/*
 * i/p
7
38 27 43 3 9 82 10

TC - O(logn to the base2)- no. of functions calls * O(n) tc for each function calls
 * */
