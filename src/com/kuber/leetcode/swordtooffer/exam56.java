package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 56 - I. 数组中数字出现的次数*/
public class exam56 {
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        int mark = 1;
        while ((n & mark) == 0) {
            mark <<= 1;
        }
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mark) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] res = singleNumbers(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
