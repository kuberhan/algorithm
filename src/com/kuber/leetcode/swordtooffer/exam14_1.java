package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 14- I. 剪绳子*/
public class exam14_1 {

    /*数学方法推导，每段分为3最后结果可最大，注意处理最后两段的情况*/
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * b;
    }

    /*动态规划dp*/
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {//j<i 可换成 j<=i/2
                dp[i] = Math.max(j * (i - j), j * dp[i - j]);
                curMax = Math.max(curMax, dp[i]);
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(cuttingRope2(10));
    }
}
