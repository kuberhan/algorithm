package com.kuber.leetcode.nowdoder;

import org.junit.Test;

public class NC59 {

    public int minPathSum (int[][] matrix) {
        // write code here
        for(int i = 1; i < matrix.length; i++){
            matrix[i][0] += matrix[i - 1][0];
        }
        for(int i = 1; i < matrix[0].length; i++){
            matrix[0][i] += matrix[0][i - 1];
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                matrix[i][j] += Math.min(matrix[i-1][j], matrix[i][j - 1]);
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    @Test
    public void test(){
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(minPathSum(matrix));
    }
}
