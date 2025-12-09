package payu.stack;

import java.util.*;

public class LargestAreaRectangleInHistogram {

	// TC: O(3n)
	// SC: O(2n)
	class Pair {
		int val;
		int index;

		public Pair(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	// store index of that element
	// find nearest smaller left indexes for each element of arr
	private int[] nsl(int[] arr) {
		int n = arr.length;
		Stack<Pair> st = new Stack<>();
		int[] ans = new int[n];
		int i = 0;
		while (i < n) {
			if (!st.isEmpty()) {
				while (!st.isEmpty() && arr[i] <= st.peek().val) {
					st.pop();
				}
			}
			if (!st.isEmpty() && arr[i] > st.peek().val) {
				ans[i] = st.peek().index;
			} else {
				ans[i] = -1;
			}
			st.push(new Pair(arr[i], i));
			i++;
		}
		return ans;
	}

	// find nearest smaller right indexes for each element of arr
	private int[] nsr(int[] arr) {
		int n = arr.length;
		Stack<Pair> st = new Stack<>();
		int[] ans = new int[n];
		int i = n - 1;
		while (i >= 0) {
			if (!st.isEmpty()) {
				while (!st.isEmpty() && arr[i] <= st.peek().val) {
					st.pop();
				}
			}
			if (!st.isEmpty() && arr[i] > st.peek().val) {
				ans[i] = st.peek().index;
			} else {
				ans[i] = n;
			}
			st.push(new Pair(arr[i], i));
			i--;
		}
		return ans;
	}

	public int largestRectangleArea(int[] arr) {
		// edge case
		int n = arr.length;
		int[] leftSmallerIndex = nsl(arr);
		int[] rightSmallerIndex = nsr(arr);
		int maxi = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int width = rightSmallerIndex[i] - leftSmallerIndex[i] - 1;
			if (rightSmallerIndex[i] == -1 && leftSmallerIndex[i] == -1) {
				width = n - i;
			}
			int area = arr[i] * width;
			maxi = Math.max(maxi, area);
		}
		return maxi;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 2, 3, 5, 4, 5, 1 };
		LargestAreaRectangleInHistogram obj = new LargestAreaRectangleInHistogram();
		System.out.println(obj.largestRectangleArea(arr));

	}

}
