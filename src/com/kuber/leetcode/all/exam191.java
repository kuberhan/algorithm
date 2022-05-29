package com.kuber.leetcode.all;


import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

/*191. 位1的个数*/
public class exam191 {

    /*n每次进行右移一位*/
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (1 & n);
            n >>= 1;
        }
        return res;
    }

    /*n & (n - 1) ，这个代码可以把 n 的二进制中，最后一个出现的 1 改写成 0*/
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(hammingWeight2(00000000000000000000000010000000));
    }
}
