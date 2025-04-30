package com.recusrion.revision;

public class WordSearch {

	int m = 0;
	int n = 0;
	int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	private boolean find(char[][] board, int i, int j, int indx, String word) {
		// base cases
		if (indx == word.length()) {
			return true;
		}
		// index out of bouds or revisiting the same cell
		if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '@') {
			return false;
		}
		// if curr character is not equal to character at index indx
		if (board[i][j] != word.charAt(indx)) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = '@';

		for (int[] dir : directions) {
			int new_i = i + dir[0];
			int new_j = j + dir[1];

			if (find(board, new_i, new_j, indx + 1, word)) {
				return true;
			}
		}
		board[i][j] = temp;
		return false;
	}

	public boolean exist(char[][] board, String word) {
		m = board.length;
		n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// first character to start the recursion on grid
				char ch = word.charAt(0);
				if (board[i][j] == ch && find(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
