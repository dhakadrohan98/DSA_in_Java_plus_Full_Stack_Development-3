package org.leetcodemedium.arr.revision2;

public class SetMatrixZeroes {
	
	 //TC: O(m*n)
    //SC: O(m*n)
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] copy = new int[m][n]; 
        //make a copy of original array otherwise original values will be lost
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(copy[i][j] == 0) {
                    //flip elements to zeroes in original array
                    func(arr, i, j);
                }
            }
        }
        return;
    }

    private void func(int[][] arr, int i, int j) {
        int m = arr.length;
        int n = arr[0].length;
        //changing column values from j to 0
        for(int col = j; col >= 0; col--) {
            arr[i][col] = 0;
        }

        //changing column values from j to n-1
        for(int col = j; col < n; col++) {
            arr[i][col] = 0;
        }
         //changing row values from i to 0
        for(int row = i; row >= 0; row--) {
            arr[row][j] = 0;
        }
        //changing row values from i to m-1
        for(int row = i; row < m; row++) {
            arr[row][j] = 0;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
