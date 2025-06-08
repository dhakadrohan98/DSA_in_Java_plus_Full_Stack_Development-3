package org.leetcodemedium.arr.revision2;

public class RotateImage {
	
	//TC: O(m*n)
    //SC: O(1)
    public void rotate(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    break;
                }
                //swap arr[i,j] <-> arr[j,i]
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        //revere each row
        for(int i = 0; i < m; i++) { 
            for(int j = 0; j < n/2; j++) {
                //swap arr[i,j] <-> arr[i,n-1-j]
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }
        return;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
