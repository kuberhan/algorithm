package com.kuber.leetcode.swordtooffer;

import org.junit.Test;


/*剑指 Offer 64. 求1+2+…+n*/
/*求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。*/
public class exam64 {

    public int sumNums(int n) {
        if (n == 0) return 0;
        return n + sumNums(n - 1);
    }

    public int sumNums2(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    @Test
    public void test() {
        System.out.println(sumNums2(3));
    }
}
