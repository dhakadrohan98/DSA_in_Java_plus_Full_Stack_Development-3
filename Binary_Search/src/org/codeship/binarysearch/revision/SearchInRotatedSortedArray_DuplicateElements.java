package org.codeship.binarysearch.revision;

// 275/282 test cases are passed
public class SearchInRotatedSortedArray_DuplicateElements {
	
	//TC: O(logn)
	//SC: O(1)
	public boolean search(int[] arr, int target) {
        int n = arr.length;
		int low = 0, high = n - 1;
		boolean ans = false;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				ans = true;
				break;
			} else if (arr[low] <= arr[mid]) {
                //left half seach space is sorted
				if (arr[low] <= target && target <= arr[mid]) {
					high = mid;
				} else {
					low = mid + 1;
				}
			} else if (arr[mid + 1] <= arr[high]) {
                //right half seach space is sorted
				if (arr[mid + 1] <= target && target <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
