package org.codeship.segment.tree;

//TC: O(2N) = O(N)
//SC: O(4N)

//range sum, min, max, GCD, Count, XOR etc -> O(logn)
//update - O(logn)
//SC- O(4n)
public class BuildSegmentTree {

	static int st[];

	public static void buildSegmentTree(int i, int l, int r, int arr[]) {
		// base case
		if (l == r) {
			st[i] = arr[l];
			return;
		}
		int mid = (l + r) / 2;
		//build the left subtree
		buildSegmentTree(2 * i + 1, l, mid, arr);
		//build the right subtree
		buildSegmentTree(2 * i + 2, mid + 1, r, arr);
		//store the sum of left & right child node into current node
		st[i] = st[(2 * i) + 1] + st[(2 * i) + 2];
	}

	public static int[] construct(int[] arr) {
		int n = arr.length;
//		int height = (int)Math.log(n/2);
//		int size = (int)Math.pow(2, height) - 1;
		//avoid index overflow
		st = new int[4 * n];

		// build the segment tree
		buildSegmentTree(0, 0, n - 1, arr);
		return st;
	}

	public static void main(String[] args) {
		int[] arr1 = { 3, 1, 2, 7, 5, 6, 3 };
		construct(arr1);
		// print the segment tree
		System.out.print("s1 -> ");
		for (int num : st) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.print("s2 -> ");
		int[] arr2 = { 3, 1, 2, 7 };
		construct(arr2);
		// print the segment tree
		for (int num : st) {
			System.out.print(num + " ");
		}
	}

}
