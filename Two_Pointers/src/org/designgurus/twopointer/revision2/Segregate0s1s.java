package org.designgurus.twopointer.revision2;

public class Segregate0s1s {
	
	//TC: O(n)
    //SC: O(1)
    public void segregate0and1(int[] arr) {
        // code here
        int n = arr.length;
        int i = n-1, j = n-2;
        while(j >= 0 && i >= 0) {
            if(arr[i] == 0) {
                while(j >= 0 && arr[j] == 0) {
                    j -= 1;
                }
                if(j >= 0)
                    swap(arr, i, j);
                
            }
            i -= 1;
            j -= 1;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
