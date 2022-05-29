package com.kuber.leetcode.all;

/*343. 整数拆分*/
public class exam343 {

    /*数学方法，每段取3最大，注意处理最后两段*/
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * b;
    }

    /*动态规划dp*/
    public int integerBreak2(int n) {
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
}
