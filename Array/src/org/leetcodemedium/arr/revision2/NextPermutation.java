package org.leetcodemedium.arr.revision2;

public class NextPermutation {

	// TC: O(3*n)
	// SC: O(1)
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void reverse(int[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

	public void nextPermutation(int[] arr) {
		int n = arr.length;
		int indx = -1;
		// step1 - find the break point
		for (int i = n - 1; i >= 1; i--) {
			if (arr[i - 1] < arr[i]) {
				indx = i - 1;
				break;
			}
		}
		// no break point is found, given array is the last permutation of series,
		// reverse the whole to get first permutation of series
		if (indx == -1) {
			reverse(arr, 0, n - 1);
			return;
		}
		// step2 - find the element just greater than indx
		int req_element = -1;
		for (int i = n - 1; i >= indx + 1; i--) {
			if (arr[indx] < arr[i]) {
				swap(arr, indx, i);
				break;
			}
		}
		// step3 - reverse the array from arr[indx+1, n-1]
		reverse(arr, indx + 1, n - 1);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
