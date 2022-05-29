package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 10- II. 青蛙跳台阶问题*/
public class exam10_2 {

    /*方法一：递归解法,超时*/
    public int numWays(int n) {
        if (n < 2) return 1;
        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
    }

    /*方法二：非递归*/
    public int numWays2(int n) {
        if (n < 2) return 1;
        int next = 0, first = 1, second = 1;
        for (int i = 2; i <= n; i++) {
            next = (first + second) % (1000000007);
            first = second;
            second = next;
        }
        return next;
    }


    @Test
    public void test() {
        System.out.println(numWays2(43));
    }
}
