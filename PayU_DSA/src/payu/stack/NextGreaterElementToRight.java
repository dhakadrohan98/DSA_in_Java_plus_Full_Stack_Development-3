package payu.stack;

import java.util.*;

class Pair {
	int val;
	int index;

	public Pair(int val, int index) {
		this.val = val;
		this.index = index;
	}
}

public class NextGreaterElementToRight {

	// TC: O(n)
	// SC: O(n)
	public ArrayList<Integer> nextLargerElement(int[] arr) {
		// code here
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		st.push(arr[n - 1]);
		int i = n - 2;
		while (i >= 0) {
			if (!st.isEmpty() && st.peek() > arr[i]) {
				list.add(st.peek());
			} else {
				while (!st.isEmpty() && st.peek() <= arr[i]) {
					st.pop();
				}
				if (!st.isEmpty()) {
					list.add(st.peek());
				} else {
					list.add(-1);
				}
			}
			st.push(arr[i]);
			i--;
		}
		Collections.reverse(list);
		return list;
	}

	// find nearest smaller left
	private static int[] nsl(int[] arr) {
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
				//if no smaller element is found for a index i then store -1 for that i in ans array for nsl
				ans[i] = -1;
			}
			st.push(new Pair(arr[i], i));
			i++;
		}
		return ans;
	}
	
	// find nearest smaller right.
		private static int[] nsr(int[] arr) {
			int n = arr.length;
			Stack<Pair> st = new Stack<>();
			int[] ans = new int[n];
			int i = n-1;
			while (i >= 0) {
				if (!st.isEmpty()) {
					while (!st.isEmpty() && arr[i] <= st.peek().val) {
						st.pop();
					}
				}
				if (!st.isEmpty() && arr[i] > st.peek().val) {
					ans[i] = st.peek().index;
				} else {
					//if no smaller element is found for a index i then store n for that i in ans array for nsr
					ans[i] = n;
				}
				st.push(new Pair(arr[i], i));
				i--;
			}
			return ans;
		}

	//main method	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 2, 3, 5, 4, 5, 1 };
		System.out.println("NSR");
		int[] res = nsl(arr);
		for (int num : res) {
			System.out.print(num + " ");
		}
		System.out.println("\nNSL");
		int[] res1 = nsr(arr);
		for (int num : res1) {
			System.out.print(num + " ");
		}
	}
}
