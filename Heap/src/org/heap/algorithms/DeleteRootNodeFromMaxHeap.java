package org.heap.algorithms;

//Time complexity: O(logN) where N is no of elements in the heap
//SC: O(1)
public class DeleteRootNodeFromMaxHeap {

	// To heapify a subtree rooted with node i which is
	// an index in arr[].Nn is size of heap
	private static void heapify(int arr[], int n, int i) {
		while (i < n) {
			int left = -1;
			int right = -1;
			int larger = 0;

			// does left child exists
			if ((2 * i) < n) {
				left = arr[2 * i];
			}
			// does right child exists
			if ((2 * i) + 1 < n) {
				right = arr[(2 * i) + 1];
			}
			// if both left & right doesn't exist
			if (left == -1 && right == -1) {
				break;
			} else if (right == -1) { // only left child exists
				larger = left;
			} else {// both left & right child exist
				larger = left > right ? 2 * i : (2 * i) + 1;
			}
			//if child node is greater than parent node's element
			if(arr[i] < arr[larger]) {
				//swap (i, larger)
				int temp = arr[i];
				arr[i] = arr[larger];
				arr[larger] = temp;
				//move i pointer to the larger child index
				i = larger;
			}
			else {
				break;
			}
		}
		return;
	}

	// Function to delete the root from Heap
	private static int deleteRoot(int arr[], int n) {
		// Get the last element
		int lastElement = arr[n - 1];
		// Replace root with first element, consider indexing of arr starting from 1
		arr[1] = lastElement;
		// Decrease size of heap by 1
		n = n - 1;
		// heapify the root node
		heapify(arr, n, 1);
		// return new size of Heap
		return n;
	}

	/* A utility function to print array of size N */
	private static void printArray(int arr[], int n) {
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver Code
	public static void main(String args[]) {
		// Array representation of Max-Heap
		// 10
		// / \
		// 5 3
		// / \
		// 2 4
		//0th index element is neglected.
		int arr[] = {0, 10, 5, 3, 2, 4 };
		// new size of arr after deleting root node
		int n = deleteRoot(arr, arr.length);
		printArray(arr, n);
	}
}
