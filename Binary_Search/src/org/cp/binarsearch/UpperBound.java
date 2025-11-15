package org.cp.binarsearch;

import java.util.Arrays;
import java.util.Scanner;

public class UpperBound {
	
//	upper bound -  smallest index in the sorted array > target.
	
	public static int upperBound(int[] arr, int target) {
        int ub = arr.length;
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] > target) {
                ub = mid;
                high -= 1;
            } else {
                low += 1;
            }
        }
        return ub; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		// TODO Auto-generated method stub
		int[] arr = {2, 3, 7, 10, 11, 11, 25};
		Arrays.sort(arr);
		System.out.println(upperBound(arr, target));

	}

}
