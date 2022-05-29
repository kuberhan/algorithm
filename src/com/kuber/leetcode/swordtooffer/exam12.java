package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 12. 矩阵中的路径*/
public class exam12 {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chars, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] chars, int m, int n, int coordinate) {
        if (!inGrid(board, m, n) || board[m][n] != chars[coordinate] )   return false;
        if (coordinate == chars.length - 1) return true;
        board[m][n] = '0';
        boolean res = dfs(board, chars, m - 1, n, coordinate + 1)
                || dfs(board, chars, m + 1, n, coordinate + 1)
                || dfs(board, chars, m, n - 1, coordinate + 1)
                || dfs(board, chars, m, n + 1, coordinate + 1);
        board[m][n] = chars[coordinate];
        return res;
    }

    public boolean inGrid(char[][] board, int m, int n) {
        return m >= 0 && m < board.length && n >= 0 && n < board[0].length;
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
        System.out.println(exist(board4, word4));
    }
}
