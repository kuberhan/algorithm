package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

import java.util.Arrays;

public class exam61 {

    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[joker] < 5;
    }

    @Test
    public void test(){
        int[] arr = {0,0,1,1,2};
        System.out.println(isStraight(arr));
    }
}
