package com.kuber.leetcode.nowdoder;

import org.junit.Test;

public class NC19 {

    public int maxsumofSubarray (int[] arr) {
        // write code here
        int max = arr[0];
        int res = 0;
        for (int num : arr) {
            res = Math.max(res + num, num);
            max =  Math.max(max, res);
        }
        return max;
    }

    @Test
    public void test(){
        int[] a ={1, -2, 3, 5, -2, 6, -1};
        System.out.println(maxsumofSubarray(a));
    }
}
