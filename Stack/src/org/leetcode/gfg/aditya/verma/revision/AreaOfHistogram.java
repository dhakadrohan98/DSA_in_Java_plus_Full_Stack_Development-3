package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

class Pair {

	int num;
	int indx;

	// args constructor
	public Pair(int num, int indx) {
		this.num = num;
		this.indx = indx;
	}
}

public class AreaOfHistogram {
	
	//TC: O(3*n)
	//SC: O(2*n)
	public static int largestRectangleArea(int[] heights) {
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
	
	public static int[] nextSmallerToLeft(int[] arr, int n) {
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

	public static int[] nextSmallerToRight(int[] arr, int n) {
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

	public static void main(String[] args) {
//		int[] nextSmallerToRight = nextSmallerToRight(arr, arr.length);
//		System.out.println("Next smaller element to right");
//		for (int num : nextSmallerToRight) {
//			System.out.print(num + " ");
//		}
//		System.out.println();
//		System.out.println("Next smaller element to left");
//		int[] nextSmallerToLeft = nextSmallerToLeft(arr, arr.length);
//		for (int num : nextSmallerToLeft) {
//			System.out.print(num + " ");
//		}
		int[] arr = new int[] { 6, 2, 5, 4, 5, 1, 6 };
		int[] arr1 = {2, 4};
		System.out.println(largestRectangleArea(arr1));

	}

}
