package com.kuber.leetcode.all;

import org.junit.Test;

public class exam53 {

    /*时间O(n)，空间O(1)的解法*/
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res > 0) res += nums[i];
            else res = nums[i];
            max = Math.max(max, res);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int res = 0;
        int max = nums[0];
        for (int num : nums) {
            res = Math.max(res + num, num);
            max = Math.max(res, max);
        }
        return max;
    }


    @Test
    public void test() {
        int[] nums = {-2,1,-3};
        System.out.println(maxSubArray2(nums));
    }
}
