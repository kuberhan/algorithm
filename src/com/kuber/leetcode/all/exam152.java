package com.kuber.leetcode.all;


import org.junit.Test;
/*
* 这个题目感觉不像动态规划，更像“最大子列和”的那种“在线处理”的解法。

如果之前有理解过“在线处理”算法的话，就能比较容易地解出这道题了。

首先假设存在某个最大乘积，然后对数组遍历，在经过每个元素的时候，有以下四种情况：

如果该元素为正数：
如果到上一个元素为止的最大乘积也是正数，那么直接乘上就好了，同样的最大乘积也会变得更大
如果到上一个元素为止的最大乘积是负数，那么最大乘积就会变成该元素本身，且连续性被断掉
如果该元素为负数：
如果到上一个元素为止的最大乘积也是负数，那么直接乘上就好了，同样的最大乘积也会变得更大
如果到上一个元素为止的最大乘积是正数，那么最大乘积就会不变，且连续性被断掉
以上四种情况中说到的最大乘积都是临时最大乘积，每遍历新的元素都需要进行比较来确定真正的最大乘积。

如果细心的话就可以发现，如果要得到乘以当前元素以后的最大乘积，需要记录最大乘积，也要记录最小乘积，因为最小值可能翻身变最大值。
* */
public class exam152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] * nums[i] > dp[i - 1]) {
                dp[i] = dp[i - 1] * nums[i];
            } else if (dp[i - 1] * nums[i] < dp[i - 1]) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums, 0, maxF, 0, len);
        System.arraycopy(nums, 0, minF, 0, len);
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(nums[i] * maxF[i - 1], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(nums[i] * minF[i - 1], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int max = maxF[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, maxF[i]);
        }

        return max;
    }

    public int maxProduct3(int[] nums) {
        int max = nums[0], tmpMax = 1, tmpMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = tmpMax;
                tmpMax = tmpMin;
                tmpMin = tmp;
            }
            tmpMax = Math.max(nums[i] * tmpMax, nums[i]);
            tmpMin = Math.min(nums[i] * tmpMin, nums[i]);
            max = Math.max(max, tmpMax);
        }
        return max;
    }

    @Test
    public void test() {
        int[] a = {2,3,-2,4,-1,2,-1,-2};
        System.out.println(maxProduct3(a));
    }
}
