package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 53 - II. 0～n-1中缺失的数字*/
/*
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
*/
public class exam53_2 {

    /*二分查找变形*/
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == mid) left = mid + 1;//说明缺少的数在mid右边
            else right = mid - 1;//说明缺少的数在mid左边
        }
        return left;
    }

    @Test
    public void test(){
        int[] n = {0,1,3};
        System.out.println(missingNumber(n));
    }
}
