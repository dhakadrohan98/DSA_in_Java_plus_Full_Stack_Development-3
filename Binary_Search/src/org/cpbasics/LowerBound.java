package org.cpbasics;

public class LowerBound {
	
//	lower bound -  smallest index in the sorted array >= target.
	
	public static int lowerBound(int[] arr, int target) {
        // code here
        int lb = arr.length;
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] >= target) {
                lb = mid;
                high -= 1;
            } else {
                low += 1;
            }
        }
        return lb;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
