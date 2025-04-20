package com.recusrion.revision;

import java.util.*;

public class NQueens_Hard {
	
	 //TC: O(n! * n)
    //SC: O(n^2 * k) where k is the number of oolutions
    private boolean isSafe(int row, int col, int n, List<String> board) {
        //check into upper vertical direction
        for(int i = 0; i < row; i++) {
            if(board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        //check for upper right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    } 

    private void solve(int row, int n, List<String> board, List<List<String>> ans) {
        //base case
        if(row == n) {
            ans.add(new ArrayList<>(board));
        }

    // TC: O(n!)
        //trying out all possible ways
        //try to place at each col if possible & go for next row
        for(int col = 0; col < n; col++) {
            //TC: O(3*n)
            if(isSafe(row, col, n, board)) {
                char[] rowArray = board.get(row).toCharArray();
                rowArray[col] = 'Q';
                board.set(row, new String(rowArray));
                solve(row + 1, n, board, ans);
                //while backtrack remove the queen & mark that pos as empty cell for next configuration
                rowArray[col] = '.';
                board.set(row, new String(rowArray));
            }
        }
        return;  
    } 

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String emptyRow = ".".repeat(n);
        for(int i = 0; i < n; i++) {
            board.add(emptyRow);
        }
        //fill queen rows wise
        solve(0, n, board, ans);
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
