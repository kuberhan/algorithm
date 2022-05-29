package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

/*剑指 Offer 17. 打印从1到最大的n位数*/
public class exam17 {

    /*不考虑大数越界的情况就很简单*/
    public int[] printNumbers(int n) {
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            max += ((int)Math.pow(10,i)) * 9;
//        }
        int max = (int) Math.pow(10, n) - 1;
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    //实际上是要考虑大数越界的情况

    @Test
    public void test() {
        int[] ints = printNumbers(2);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
