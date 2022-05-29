package com.kuber.leetcode.nowdoder;

import org.junit.Test;

public class NC109 {

    public int solve (char[][] grid) {
        // write code here
        int isLandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){//遇到等于1的格子，以它为树根节点，遍历，将遇到遍历过的1变成0即可
                    isLandCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return isLandCount;
    }

    public void dfs(char[][] grid, int row, int column){
        if (!isLand(grid, row, column)) return;
        if (grid[row][column] != '1') return;
        grid[row][column] = '0';
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
    }


    public boolean isLand(char[][] grid, int row, int column){
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    @Test
    public void test(){
        char[][] g1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        char[][] g2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        char[][] g3 = {
                {'1','1','0','0','0'},
                {'0','1','0','1','1'},
                {'0','0','0','1','1'},
                {'0','0','0','0','0'},
                {'0','0','1','1','1'}};
        System.out.println(solve(g3));
    }
}
