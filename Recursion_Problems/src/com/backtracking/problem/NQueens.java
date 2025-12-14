package com.backtracking.problem;

import java.util.*;

public class NQueens {

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		List<List<String>> ans = new ArrayList<>();
		for (char[] arr : board) {
			Arrays.fill(arr, '.');
		}
		rec(0, board, ans);
		// build the ans in required format
		return ans;
	}

	private void rec(int col, char[][] board, List<List<String>> ans) {
		// base case
		if (col == board.length) {
			// store board combination in list of list<string> in required format
			int n = board.length;
			List<String> temp = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				// each col for ith row
				for (int j = 0; j < n; j++) {
					sb.append(board[i][j]);
				}
				temp.add(sb.toString());
			}
			ans.add(temp);
			return;
		}

		for (int i = 0; i < board.length; i++) {
			if (canQueenPlaced(i, col, board)) {
				board[i][col] = 'Q';
				rec(col + 1, board, ans);
				// undo steps
				board[i][col] = '.';
			}
		}
		return;
	}

	private boolean canQueenPlaced(int row, int col, char[][] board) {
		int originalRow = row;
		int originalCol = col;
		// checking left upper Diagonal
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row--;
			col--;
		}
		// reset row & col value to original value
		row = originalRow;
		col = originalCol;
		// check left diagonal
		while (col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			col--;
		}
		// check left lower Diagonal
		row = originalRow;
		col = originalCol;
		while (row < board.length && col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row += 1;
			col--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens nQueens = new NQueens();
		List<List<String>> solveNQueens = nQueens.solveNQueens(4);
		System.out.println(solveNQueens);
	}

}
