package org.codeship;

import java.util.Arrays;

public class NonOverlappingIntervals {
	
	//TC: O(nlogn) + O(n)
    //SC: O(1)
    public int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;
        //sort the array based on ending time
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int lastEndTime = arr[0][1];
        int cnt = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i][0] >= lastEndTime) {
                cnt += 1;
                lastEndTime = arr[i][1];
            }
        }
        return n - cnt;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
