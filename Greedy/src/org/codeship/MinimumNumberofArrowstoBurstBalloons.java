package org.codeship;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
	
	//TC: O(nlogn)
    //SC: O(logn)
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int[] prev = points[0];
        int count = 1;
        for(int i = 1; i < n; i++) {
            int currSP = points[i][0];
            int currEP = points[i][1];
            int prevSP = prev[0];
            int prevEP = prev[1];

            if(currSP > prevEP) { //no overlap
                count++;
                prev = points[i];
            } else { //overlap condition
                //get the overlapping interval
                prevSP = Math.max(currSP, prevSP);
                prevEP = Math.min(currEP, prevEP);
            }
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
