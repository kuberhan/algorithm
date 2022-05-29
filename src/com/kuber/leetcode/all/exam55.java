package com.kuber.leetcode.all;

import org.junit.Test;

/*
如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3个格子都可以作为起跳点。
可以对每一个能作为起跳点的格子都尝试跳一次，把能跳到最远的距离不断更新。
如果可以一直跳到最后，就成功了。
*/
public class exam55 {

    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= max) {
                if (max <= (nums[i] + i)) {
                    max = nums[i] + i;
                }
            }
        }
        return max >= nums.length - 1;
    }

    //看起来更简便，但实际性能不如上一种
    public boolean canJump2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max,nums[i] + i);
            }
        }
        return max >= nums.length - 1;
    }

    @Test
    public void test() {
        int[] nums = {0};
        System.out.println(canJump2(nums));
    }
}
