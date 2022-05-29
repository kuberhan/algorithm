package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 04. 二维数组中的查找*/
public class exam04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length - 1, column = 0;
        while (row >= 0 && column < matrix[0].length){
            if (matrix[row][column] < target){
                column++;
            }else if (matrix[row][column] > target){
                row--;
            }else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] m = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(m, 16));
    }

}
