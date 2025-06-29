package org.designgurus.twopointer.revision2;

public class SortColors {

	// TC: O(n)
	// SC: O(1)
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sortColors(int[] arr) {
		int n = arr.length;
		int i = 0, j = 0, k = n - 1;
		while (j <= k) {
			if (arr[j] == 0) {
				swap(arr, i, j);
				i++;
				j++;
			} else if (arr[j] == 2) {
				swap(arr, j, k);
				k--;
			} else { // arr[j] == 1
				j++;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
