package org.oa.sample;

public class NextPermutation {

	// TC: O(n)
	// SC: O(n)
	public void nextPermutation(int[] arr) {
		int n = arr.length;
		int indx = -1;h
		//1 try to match the longest prefix
		for(int i = n-2; i >= 0; i--) {
			if(arr[i] < arr[i+1]) {
				indx = i;
				break;
			}
		}
		//we did not found the dip
		if(indx == -1) {
			reverse(arr, 0, n-1);
			return;
		}
		
		//2 we need a number just greater than array num
		for(int i = n-1; i >= indx; i--) {
			if(arr[indx] > arr[i]) {
				//swap (arr[indx], arr[i])
				int temp = arr[indx];
				arr[indx] =  arr[i];
				arr[i] = temp;
				break;
			}
		}
		
		//3 reverse(indx+1, n-1)
		reverse(arr, indx+1, n-1);
	}

	private void reverse(int[] arr, int i, int j) {
		while (i < arr.length && j >= 0 && i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {}

}
