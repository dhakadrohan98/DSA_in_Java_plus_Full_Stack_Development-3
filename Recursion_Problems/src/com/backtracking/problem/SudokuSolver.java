package com.backtracking.problem;

public class SudokuSolver {

	// Total no. of cell = 9 *9 = 81(E)
	// For each empty cell, we try digits '1' to '9'.
	// TC: O(9^E)
	// SC: O(9*9) = O(81) = O(1) stack space
	public void solveSudoku(char[][] board) {
		dfs(0, 0, board);
		return;
	}

	private boolean dfs(int row, int col, char[][] board) {
		// if all cols of a row are covered, move to next row simply
		if (col == 9) {
			row += 1;
			col = 0;
		}

		// one base case only
		// if all rows are covered
		if (row == 9) {
			return true;
		}

		// skip filled cells & move to next cols
		if (board[row][col] != '.') {
			return dfs(row, col + 1, board);
		}

		// check for all numbers 1 to 9 for same row
		for (char num = '1'; num <= '9'; num++) {
			if (canPlace(row, col, num, board)) {
				board[row][col] = num;
				// stop once solved
				if (dfs(row, col + 1, board)) {
					return true;
				}

				// redo the cell changes only if board is not solved yet
				board[row][col] = '.';
			}
		}
		return false;
	}

	private boolean canPlace(int row, int col, char num, char[][] board) {
		// row check
		for (int cc = 0; cc < 9; cc++) {
			if (board[row][cc] == num) {
				return false;
			}
		}
		// col check
		for (int r = 0; r < 9; r++) {
			if (board[r][col] == num) {
				return false;
			}
		}

		// 3*3 grid check
		int startingRow = (row / 3) * 3;
		int startingCol = (col / 3) * 3;
		for (int i = startingRow; i < startingRow + 3; i++) {
			for (int j = startingCol; j < startingCol + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
