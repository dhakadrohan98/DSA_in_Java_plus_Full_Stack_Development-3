package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

public class MaximumAreaOfRectangleInBinaryMatrix {
	
	public int[] nextSmallerToLeft(int[] arr, int n) {
		int[] res = new int[n];
		Stack<Pair> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && st.peek().num >= arr[i]) {
				st.pop();
			}
			if (!st.isEmpty()) {
				res[i] = st.peek().indx;
			} else { // stack became empty means no smaller element is found to the left
				res[i] = -1;
			}
			st.push(new Pair(arr[i], i));
		}
		return res;
	}

	public int[] nextSmallerToRight(int[] arr, int n) {
		int[] res = new int[n];
		Stack<Pair> st = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && st.peek().num >= arr[i]) {
				st.pop();
			}
			// st.peek <= arr[i]
			if (!st.isEmpty()) {
				res[i] = st.peek().indx;
			} else {
				//if no smaller element is found on the right side, it means it is present out of the indexes(0-based indexing)
				//at pos n
				res[i] = n;
			}
			st.push(new Pair(arr[i], i));
		}
		return res;
	}

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftIndexes = nextSmallerToLeft(heights, n);
        int[] rightIndexes = nextSmallerToRight(heights, n);
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
        	int width = rightIndexes[i] - leftIndexes[i] - 1;
        	area = Math.max(area, heights[i] * width);
        }
        return area;
    }

//TC: O(n*m) + O(n * 3*n)
//Sc: O(2*n) O(m) due to keep track of buildings height (vector)
    public int maximalRectangle(char[][] matrix) {
        //One base case
		if (matrix.length == 0 || matrix[0].length == 0)
	        return 0;
		
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] arr = new int[n][m];
		//convert char matrix into integer matrix
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
                //convert char into num
                //arr[i][j] = matrix[i][j] - '0';
				arr[i][j] = Character.getNumericValue(matrix[i][j]);
			}
		}
		//storing values of first row of arr into vector, keep i=0 as fixed while fetching value from arr
		int[] vector = arr[0];
		int max = largestRectangleArea(vector);
		//proceed for 1st till n-1th row
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < m; j++) {
				//if j^th column's building is not at ground.
				if(arr[i][j] == 0) {
					vector[j] = 0;
				}
				else {
					vector[j] = vector[j] + 1;
				}
			}
			//pass new updated vector into MAH method to get max area of building till curr rows
			max = Math.max(max, largestRectangleArea(vector));
		}
		
		return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
