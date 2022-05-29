package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.Arrays;
/*
对于所有的数字，只有两类：

奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
          举例：
         0 = 0       1 = 1
         2 = 10      3 = 11
偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
           举例：
          2 = 10       4 = 100       8 = 1000
          3 = 11       6 = 110       12 = 1100
*/
public class exam338 {

    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < num + 1; i++) {
            int count = 0;
            while (dp[i] > 0) {
                int left = dp[i] % 2;
                if (left == 1) count++;
                dp[i] = dp[i] / 2;
            }
            dp[i] = count;
        }
        return dp;
    }

    public int[] countBits2(int num) {
        int dp[] = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i < num + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(countBits2(8)));
    }
}
