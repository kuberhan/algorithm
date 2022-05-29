package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

/*剑指 Offer 03. 数组中重复的数字*/
public class exam03 {

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if(nums[i] != i){
                if(nums[i] == nums[nums[i]]) return nums[i];
                else {
                    int tem = nums[i];
                    nums[i] = nums[tem];
                    nums[tem] = tem;
                }
            }else i++;
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
