package com.kuber.leetcode.islandproblem;

import org.junit.Test;


/*463. 岛屿的周长*/
public class exam463 {
    /*将网格问题转化成树来做*/
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) return dfs(grid,i,j);
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (!isArea(grid, r, c))    return 1;//超出网格范围，也要返回一条边
        if(grid[r][c] == 0)   return 1;//遇到海洋格子，返回一条边
        if(grid[r][c] == 2) return 0;//遇到遍历过的格子，返回0
        grid[r][c] = 2;//遍历过的格子赋值2
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    public boolean isArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    @Test
    public void test(){
        int[][] g = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(g));
    }
}
