package com.kuber.leetcode.all;


import org.junit.Test;

/*33. 搜索旋转排序数组*/
public class exam33 {

    /*方法一：双指针，比O(n)快*/
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if (nums[left] == target)   return left;
            if(nums[right] == target)   return right;
            left += 1;
            right -= 1;
        }
        return -1;
    }

    /*方法二：二分法,时间复杂度O(log n)*/
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > nums[right]){//左边有序
                if (target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {//右边有序
                if(target >= nums[mid] && target <= nums[right]){//target处于右边则二分
                    left = mid + 1;
                }else {//target处于左边再对左边进行分析
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {1};
        System.out.println(search2(nums, 0));
    }
}
