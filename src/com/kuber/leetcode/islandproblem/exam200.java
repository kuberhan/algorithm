package com.kuber.leetcode.islandproblem;

import org.junit.Test;

/*200. 岛屿数量*/
public class exam200 {

    /*将网格抽象为数，不过是个四叉树，对比二叉树进行深度优先遍历*/
    public int numIslands(char[][] grid) {
        int areaCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){//遇到等于1的格子，以他为树根节点开始遍历，遍历过就赋值0，相当于一个小岛最后只有一个格1
                    areaCount++;
                    dfs(grid, i, j);
                }

            }
        }
        return areaCount;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (!isArea(grid, r, c))    return;
        if(grid[r][c] != '1')   return;
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public boolean isArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
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
        System.out.println(numIslands(g2));

    }
}
