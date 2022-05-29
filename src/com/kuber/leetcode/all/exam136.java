package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.Arrays;

/*136. 只出现一次的数字*/
public class exam136 {

    /*先排序，然后遍历删选，对2进行取余*/
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            counter++;
            if(counter % 2 == 1 && nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /*位运算的典型题目：异或运算*/
    /*异或运算的三个性质：
    1.任何数和 0 做异或运算，结果仍然是原来的数
    2.任何数和其自身做异或运算，结果是 0
    3.异或运算满足交换律和结合律
    */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber2(nums));
    }
}
