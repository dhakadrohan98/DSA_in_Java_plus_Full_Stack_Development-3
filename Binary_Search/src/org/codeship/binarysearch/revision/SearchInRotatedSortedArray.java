package org.codeship.binarysearch.revision;

public class SearchInRotatedSortedArray {
	
	 //TC: O(logn)
    //SC: O(1)
    public int search(int[] arr, int target) {
        int n  = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                ans = mid;
                break;
            } else if(arr[low] <= arr[mid]) {
                if(arr[low] <= target && target <= arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else if(arr[mid+1] <= arr[high]) {
                if(arr[mid+1] <= target && target <= arr[high]) {
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
