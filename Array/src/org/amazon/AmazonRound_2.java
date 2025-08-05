package org.amazon;

public class AmazonRound_2 {
	
	// Rohan Dhakad - SDE[C] - 03/Jul/2025 - 12PM to 1PM

	/*
	Question 1 

	Given a 9x9 incomplete sudoku, solve it such that it becomes valid sudoku. Valid sudoku has the following properties.

	         1. All the rows should be filled with numbers(1 - 9) exactly once.

	         2. All the columns should be filled with numbers(1 - 9) exactly once.

	         3. Each 3x3 submatrix should be filled with numbers(1 - 9) exactly once.

	Note: Character '.' indicates empty cell.

	Input:

	[9, 3, 1, 2, 7, ., ., ., .],
	[6, ., ., 1, 9, 5, ., ., .],
	[., 5, 8, ., ., ., ., 6, .],      (consider 1 based indexing)
	[8, ., ., ., 6, ., ., ., 3],       i=4, j = 7
	                                    consider for 0 based indexing                                i=3, j=6
	[4, ., ., 8, ., 3, ., x, 1],       con_row = 0, con_col = 0
	[7, ., ., ., 2, ., ., ., 6],         4/3 = 1
	[., 6, ., ., ., ., 2, 8, .],         7/3 = 2
	[., ., ., 4, 1, 9, ., ., 5],       (3 * 1) + i /3 
	[., ., ., ., 8, ., ., 7, 9]

	consider for 0 based indexing 
	i=4, j = 7

	4/3 = 1p
	7/3 = 2

	i=5, j =8   ||  1,2

	for(int k -> 0 to 9) {
	    
	    con_row = 3 * (row/3) + k / 3; -> 3
	    con_col = 3 * (col / 3) + k % 3; -> 3
	    
	}

	Output: 
	[9,3,1,2,7,4,8,5,4],
	[6,7,2,1,9,5,3,4,8],
	[1,5,8,3,4,2,7,6,9],
	[8,9,5,7,6,1,4,2,3],
	[4,2,6,8,5,3,9,7,1],
	[7,1,3,9,2,8,5,4,6],
	[2,6,7,5,3,4,2,8,1],
	[8,4,3,4,1,9,6,2,5],
	[5,1,4,6,8,2,3,7,9]

	*/

	grid[i][0 to 8] - vetically
	grid[0 to 8][j] - horizontally
	---------------------------------------------------------------------------------------


	public void sudoku(char[][] board) {
	    solve(board);
	}

	private boolean solve(char[][] board) {
	    for(int i = 0; i < 9; i++) {
	        for(int j = 0; j < 9; j++) {
	            if(board[i][j] == '.') {
	                for(char c = '1'; c <= '9'; c++) {
	                    if(isValid(board, i, j, c)) {
	                        board[i][j] = c;
	                        
	                        if(solve(board)) {
	                            return true;
	                        }
	                        //backtrack steps
	                        board[i][j] = '.';
	                    }
	                }
	                return false;
	            }
	        }
	    }
	    return true;
	}

	private boolean isValid(char[][] board, int i, int j, char c) {
	    for(int k = 0; k < 9; k++) {
	        //horizontal
	        //vetical checks
	        if(board[i][k] == c) return false;
	        if(board[k][j] == c) return false;
	        
	        int convRow = 3 * (row /3) + k / 3;
	        int convCol = 3 * (col / 3) + k % 3;
	        if(board[convRow][convRow] == c) {
	            return false;
	        }
	    }
	    return true;
	}

	TC: O(9^n)
	SC: O(n) stack space

	solve(i,j)
	! ! ! ! ! ! ! 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
