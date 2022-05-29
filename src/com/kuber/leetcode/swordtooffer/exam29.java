package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*剑指 Offer 29. 顺时针打印矩阵*/
public class exam29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int max = matrix.length * matrix[0].length;
        int[] res = new int[max];
        int len = 0;
        while (len < max){
            //从左往右
            for (int i = left; i <= right; i++) {
                if (len == max) break;
                res[len] = matrix[top][i];
                len++;
            }
            top++;
            //从上到下
            for (int i = top; i <= bottom; i++) {
                if (len == max) break;
                res[len] = matrix[i][right];
                len++;
            }
            right--;
            //从右到左
            for (int i = right; i >= left; i--) {
                if (len == max) break;
                res[len] = matrix[bottom][i];
                len++;
            }
            bottom--;
            //从下到上
            for (int i = bottom; i >= top; i--) {
                if (len == max) break;
                res[len] = matrix[i][left];
                len++;
            }
            left++;
        }
        return res;
    }

    @Test
    public void test(){
        int[][] m = {
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        int[][] m2 = {
                {1,2,3},{4,5,6,},{7,8,9}
        };
        int[] ints = spiralOrder(new int[0][]);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
