package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 15. 二进制中1的个数*/
public class exam15 {

    //位运算+异或来做
    public int hammingWeight(int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            counter += 1 & n;
            n >>= 1;
        }
        return counter;
    }

    /*n & (n - 1) ，这个代码可以把 n 的二进制中，最后一个出现的 1 改写成 0
     *  (n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1。
     *   n&(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
     * */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight2(11));
    }
}
