package com.kuber.leetcode.all;


import org.junit.Test;

/*34. 在排序数组中查找元素的第一个和最后一个位置*/
public class exam34 {
    public int[] searchRange(int[] nums, int target) {
        int a = search(nums, target - 1);
        int b = search(nums, target);
        if (b - a == 0) return new int[]{-1,-1};
        return new int[]{a, b - 1};
    }

    public int search(int[] nums, int target){
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
        int[] n = {5,7,7,8,8,10};
        int[] range = searchRange(n, 6);
        for (int i : range) {
            System.out.print(i + " ");
        }
    }
}
