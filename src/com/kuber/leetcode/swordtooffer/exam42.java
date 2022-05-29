package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 42. 连续子数组的最大和*/
/*53. 最大子序和*/
public class exam42 {

    /*时间复杂度O(N),空间复杂度O(N)*/
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /*时间复杂度O(N),空间复杂度O(1)*/
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res > 0) res += nums[i];
            else res = nums[i];
            max = Math.max(res, max);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int res = 0;
        String s = "df";
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
