package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 10- I. 斐波那契数列*/
public class exam10_1 {

    /*普通斐波那契*/
    public int fib(int n) {
        if(n < 2) return n;
        int first = 0, second = 1, next = 0;
        for (int i = 2; i <= n; i++) {
            next = (first + second) % 1000000007;
            first = second;
            second = next;
        }
        return next;
    }

    /*优化斐波那契*/
    public int fib2(int n) {
        int first = 0, second = 1, next = 0;
        for (int i = 0; i < n; i++) {
            next = (first + second) % 1000000007;
            first = second;
            second = next;
        }
        return first;
    }

    @Test
    public void test(){
        System.out.println(fib2(1));
    }
}
