package com.kuber.leetcode.all;

import org.junit.Test;

public class exam300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] path = new int[len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    path[i] = Math.max(path[j], path[i]);
                }
            }
            path[i] += 1;
            max = Math.max(path[i],max);
        }
        return max;
    }

    @Test
    public void test(){
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int[] nums2 = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }
}
