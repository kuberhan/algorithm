package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*54. 螺旋矩阵*/
/*跟剑指offer29题一样*/
public class exam54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int max = matrix.length * matrix[0].length;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int len = 0;
        while (len < max){
            //从左往右
            for (int i = left; i <= right; i++) {
                if (len == max) break;
                res.add(matrix[top][i]);
                len++;
            }
            top++;
            //从上到下
            for (int i = top; i <= bottom; i++) {
                if (len == max) break;
                res.add(matrix[i][right]);
                len++;
            }
            right--;
            //从右往左
            for (int i = right; i >= left; i--) {
                if (len == max) break;
                res.add(matrix[bottom][i]);
                len++;
            }
            bottom--;
            //从下到上
            for (int i = bottom; i >= top; i--) {
                if (len == max) break;
                res.add(matrix[i][left]);
                len++;
            }
            left++;
        }
        return res;
    }

    @Test
    public void test(){
        int[][] m ={
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        System.out.println(spiralOrder(m));
    }
}
