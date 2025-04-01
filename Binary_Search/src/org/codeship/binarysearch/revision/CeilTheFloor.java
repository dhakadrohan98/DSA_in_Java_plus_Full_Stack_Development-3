package org.codeship.binarysearch.revision;

public class CeilTheFloor {
	
	//TC: O(2logn)
    //SC: O(1)
    public static int findFloor(int[] arr, int n, int x) {
      int low = 0, high = n-1;
      int ans = -1;
      while(low <= high) {
        int mid = (low + high) / 2;
        if(arr[mid] <= x) {
          ans = arr[mid];
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return ans;
    }

    public static int findCeil(int[] arr, int n, int x) {
      int low = 0, high = n-1;
      int ans = -1;
      while(low <= high) {
        int mid = (low + high) / 2;
        if(arr[mid] >= x) {
          ans = arr[mid];
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      return ans;
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
      int floor = -1;
      int ceil = -1;
      floor = findFloor(arr, n, x);
      ceil = findCeil(arr, n, x);
      return new int[]{floor,  ceil};
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
