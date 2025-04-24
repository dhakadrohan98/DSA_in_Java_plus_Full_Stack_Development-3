package com.recusrion.striver;

public class SudokuSolver {
	
	private boolean isValid(char[][] board, int row, int col, char ch) {
        for(int i = 0; i < 9; i++) {
            //checking for entire row
            if(board[row][i] == ch) return false;
            //checking for entire col
            if(board[i][col] == ch) return false;
            //check into 3*3 current grid
            int tempRowCoord = (3 * (row / 3)) + i / 3 ;
            int tempColCoord = (3 * (col / 3)) + i % 3;
            if(board[tempRowCoord][tempColCoord] == ch) return false;
        }
        return true;
    }

    private boolean solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == '.') {

                    for(char ch = '1'; ch <= '9'; ch++) {
                        if(isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            //if board is solved through any one configuration then return true from every recursive function call
                            if(solve(board) == true) {
                                return true;
                            }
                            else {
                                 //undo the cell value to empty cell while backtracking
                                board[i][j] = '.';
                            }
                        }
                    }
                    //filling curr (i,j) cell from char 1 to 9 is not possible hence return false;
                    return false;
                }
            }
        }
        //board is filled with valid configuration of characters(1 to 9)
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
