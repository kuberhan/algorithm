package com.kuber.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustTest {


    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public int rob2(int[] nums) {
        int left = 0, right = 0;
        for (int num : nums) {
            int tmp = right;
            right = Math.max(left + num, right);
            left = tmp;
        }
        return right;
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,1};
        int[] arr2 = {};
        System.out.println(rob2(arr2));
    }
}
