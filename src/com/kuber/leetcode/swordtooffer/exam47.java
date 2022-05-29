package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

/*剑指 Offer 47. 礼物的最大价值*/
public class exam47 {

    public int maxValue(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test(){
        int[][] path = {{1,3,1},
                {1,5,1},
                {4,2,1}};
        System.out.println(maxValue(path));
    }
}
