package com.kuber.leetcode.all;

import org.junit.Test;

public class exam70 {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] sum = new int[n];
        sum[0] = 1;
        sum[1] = 2;
        for (int i = 2; i < n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n-1];
    }

    public int climbStairs2(int n) {
        if(n <= 2) return n;
        int first = 1, second = 2, next = 0;
        for (int i = 2; i < n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }

    @Test
    public void test(){
        int i = climbStairs2(5);
        System.out.println(i);
    }
}
