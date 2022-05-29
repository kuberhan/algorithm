package com.kuber.leetcode.all;

import org.junit.Test;

/*75. 颜色分类*/
public class exam75 {
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for (int num : nums) {
            if(num == 0) num0++;
            else if(num == 1) num1++;
            else num2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i < num0) nums[i] = 0;
            else if(i<num0+num1 && i >= num0) nums[i] = 1;
            else nums[i] = 2;
        }
/*        for (int num : nums) {
            System.out.println(num);
        }*/
    }

    @Test
    public void test(){
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
}
