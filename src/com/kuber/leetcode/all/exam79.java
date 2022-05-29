package com.kuber.leetcode.all;

import org.junit.Test;

/*79. 单词搜索*/
public class exam79 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int m, int n, int coordinate) {
        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length || words[coordinate] != board[m][n])  return false;
        if (coordinate == words.length - 1) return true;
        board[m][n] = '0';
        boolean res = dfs(board, words, m - 1, n, coordinate + 1) ||
                dfs(board, words, m + 1, n, coordinate + 1) ||
                dfs(board, words, m, n - 1, coordinate + 1) ||
                dfs(board, words, m, n + 1, coordinate + 1);
        board[m][n] = words[coordinate];
        return res;
    }

    @Test
    public void test(){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        char[][] board2 = {{'a','b'},{'c','d'}};
        String word2 = "abcd";

        char[][] board3 = {{'a'}};
        String word3 = "b";

        char[][] board4 = {{'a','a'}};
        String word4 = "aaa";
        System.out.println(exist(board, word));
    }
}
