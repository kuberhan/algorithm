package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.Arrays;

public class exam59 {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n -1;
        int[][] mat = new int[n][n];
        int num = 1, ter = n * n;
        while(num <= ter){
            for (int i = left; i <= right; i++) {
                mat[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++){
                mat[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--){
                mat[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--){
                mat[i][left] = num++;
            }
            left++;
        }
        return mat;
    }

    @Test
    public void test1(){
        int[][] ints = generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ints[i][j]+",");
            }
            System.out.println();
        }

    }
}
