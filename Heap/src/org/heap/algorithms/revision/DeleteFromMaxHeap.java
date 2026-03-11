package org.heap.algorithms.revision;


//TC: O(logn)
//SC: O(1)
public class DeleteFromMaxHeap {

	// To heapify a subtree rooted with node i which is
	// an index in arr[].Nn is size of heap
	private static void heapify(int arr[], int n, int i) {
		while (i < n) {
			int left = (2 * i) + 1;
			int right = (2 * i) + 2;
			// if right element is out of index then check the left element existence
			if (right >= n) {
				if (left >= n) {
					break;
				}
				
				if(arr[i] < arr[left]) {
					swap(arr, i, left);
					i = left;
				}
			} else { // left < n && right < n
				int largest = arr[left] > arr[right] ? left : right;
				if (arr[i] < arr[largest]) {
					swap(arr, i, largest);
					i = largest;
				} else {
					break;
				}
			}
		}
		return;
	}

	// Function to delete the root from Heap
	private static int deleteRoot(int arr[], int n) {
		// Get the last element
		int lastElement = arr[n - 1];
		// Replace root with first element, consider indexing of arr starting from 0
		arr[0] = lastElement;
		// Decrease size of heap by 1
		n = n - 1;
		// heapify the root node
		heapify(arr, n, 0);
		// return new size of Heap
		return n;
	}

	/* A utility function to print array of size N */
	private static void printArray(int arr[], int n) {
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Driver Code
	public static void main(String args[]) {
		// Array representation of Max-Heap
		// 10
		// / \
		// 5 3
		// / \
		// 2 4
		// 0th index element is neglected.
		int[] arr = {0, 10, 5, 3, 2, 4 };
		int[] arr1 = {40, 30, 10, 20, 15};
		// new size of arr after deleting root node
		int n = deleteRoot(arr, arr.length);
		printArray(arr, n);
		
		int n1 = deleteRoot(arr1, arr1.length);
		printArray(arr1, n1);
		
	}
}
