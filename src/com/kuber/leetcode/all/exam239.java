package com.kuber.leetcode.all;

import org.junit.Test;

/*239. 滑动窗口最大值*/
public class exam239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[1];
        if(k <= nums.length) {
            res = new int[nums.length - k + 1];
            right = k - 1;
        }
        while (right < nums.length){
            int max = nums[left];
            int temp = left;
            while (temp < right){
                max = Math.max(max, nums[temp + 1]);
                temp++;
            }
            res[left] = max;
            left++;
            right++;
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums2 = {1,-1};
        int[] res = maxSlidingWindow(nums2,2);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
