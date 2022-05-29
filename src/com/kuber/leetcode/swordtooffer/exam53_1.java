package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

import javax.swing.*;

/*剑指 Offer 53 - I. 在排序数组中查找数字 I*/
/*34. 在排序数组中查找元素的第一个和最后一个位置*/
public class exam53_1 {

    /*先找到最左边的target*/
    public int search(int[] nums, int target) {
        return searchLast(nums, target) - searchLast(nums, target - 1);
    }

    /*先找到最后一个target的下标，再减去target-1的下标*/
    public int searchLast(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    @Test
    public void test(){
        int[] n = {5,8,8,10};
        System.out.println(search(n, 8));
    }
}
