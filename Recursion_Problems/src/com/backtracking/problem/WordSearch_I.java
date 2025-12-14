package com.backtracking.problem;

public class WordSearch_I {
	
	//TC: O((m*n) * 4^L)  L = length of word
	//SC: O((m*n)+ L)
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //dfs on each grid starting with char as first letter
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, 0, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k, char[][] board, String word, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        //base cases

        //word search is finished means exhausted length of the word 
        if(k >= word.length()) {
            return true;
        }

        //out of the board
        if(i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        //if cell is already visited
        if (visited[i][j]) {
            return false;
        }

        //not a valid path
        if(board[i][j] != word.charAt(k)) {
            return false;
        }

        visited[i][j] = true;
        boolean up = dfs(i-1, j, k+1, board, word, visited);
        boolean right = dfs(i, j+1, k+1, board, word, visited);
        boolean down = dfs(i+1, j, k+1, board, word, visited);
        boolean left = dfs(i, j-1, k+1, board, word, visited);

        if(up || right || down || left) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
