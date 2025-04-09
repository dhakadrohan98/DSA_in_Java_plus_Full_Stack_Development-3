package org.leetcode.gfg.aditya.verma;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//Aditya Verma code has run for all test cases on Leetcode
//TC: O(n*m) + O(n * 3*n)
//Sc: O(2*n) O(m) due to keep track of buildings height (vector)
public class MaximumAreaOfRectangleInBinaryMatrix {

	// NSR (int[] right)
	public static int[] nextSmallerElement(int[] nums, int n) {
		// Stack containing pair<nsE, indx>
		Stack<Data> st = new Stack<>();
		int[] right = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			// 1st check
			if (st.size() == 0) {
				right[i] = n;
			} // 2nd check]
			else if (st.size() > 0 && st.peek().ngl < nums[i]) {
				Data temp = st.peek();
				int index = temp.index;
				right[i] = index;
			} // 3rd check
			else if (st.size() > 0 && st.peek().ngl >= nums[i]) {
				while (st.size() > 0 && st.peek().ngl >= nums[i]) {
					st.pop();
				}
				// 4ht check
				if (st.size() == 0) {
					right[i] = n;
				}
				// if (st.peek() > nums[i])
				else {
					Data temp = st.peek();
					int index = temp.index;
					right[i] = index;
				}
			}
			// outside of all if, else if conditions, push current element into the stack.
			st.push(new Data(nums[i], i));
		}

		return right;
	}

	// NSL (int[] left)
	public static int[] prevSmaller(int[] nums, int n) {
		int[] left = new int[n];
		Stack<Data> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			// 1st check
			if (st.size() == 0) {
				left[i] = -1;
			} // 2nd check]
			else if (st.size() > 0 && st.peek().ngl < nums[i]) {
				Data temp = st.peek();
				int index = temp.index;
				left[i] = index;
			} // 3rd check
			else if (st.size() > 0 && st.peek().ngl >= nums[i]) {
				while (st.size() > 0 && st.peek().ngl >= nums[i]) {
					st.pop();
				}
				// 4ht check
				if (st.size() == 0) {
					left[i] = -1;
				}
				// if (st.peek() > nums[i])
				else {
					Data temp = st.peek();
					int index = temp.index;
					left[i] = index;
				}
			}
			// outside of all if, else if conditions, push current element into the stack.
			st.push(new Data(nums[i], i));
		}
		return left;
	}

	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] right = nextSmallerElement(heights, n);
		int[] left = prevSmaller(heights, n);

		// width arr
		int[] width = new int[n];
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			width[i] = right[i] - left[i] - 1;
			int area = heights[i] * width[i];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	public static int maximalRectangle(char[][] matrix) {
		// Two base cases
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int n = matrix.length;
		int m = matrix[0].length;
		int[][] arr = new int[n][m];
		// convert char matrix into integer matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// convert each char into num
				// arr[i][j] = matrix[i][j] - '0';
				arr[i][j] = Character.getNumericValue(matrix[i][j]);
			}
		}
		// storing values of first row of arr into vector, keep i=0 as fixed while
		// fetching value from arr
		int[] vector = arr[0];
		int max = largestRectangleArea(vector);
		// proceed for 1st till n-1th row
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// if j^th column's building is not at ground.
				if (arr[i][j] == 0) {
					vector[j] = 0;
				} else {
					vector[j] = vector[j] + 1;
				}
			}
			// pass new updated vector into MAH method to get max area of building till curr
			// rows
			max = Math.max(max, largestRectangleArea(vector));
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int n = sc.nextInt();
		System.out.println("Enter the number of columns");
		int m = sc.nextInt();
		char[][] matrix = new char[n][m];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				char ch = sc.next().charAt(0);
				matrix[i][j] = ch;
			}
		}
		// input:
//			0 1 1 0
//			1 1 1 1
//			1 1 1 1
//			1 1 0 0
		System.out.println(maximalRectangle(matrix));
	}

}
