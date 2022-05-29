package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*15. 三数之和*/
public class exam15 {
    /**
     * 排序 + 双指针
     * 本题的难点在于如何去除重复解。
     *
     * 算法流程：
     * 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     * 对数组进行排序。
     * 遍历排序后数组：
     * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R移到下一位置，寻找新的解
     * 若和大于 0，说明 nums[R] 太大，R 左移
     * 若和小于 0，说明 nums[L] 太小，L 右移
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                if (nums[i] + nums[begin] + nums[end] < 0) {
                    begin++;
                } else if (nums[i] + nums[begin] + nums[end] == 0) {
                    while (begin < end && nums[begin] == nums[begin + 1]) begin++;
                    while (begin < end && nums[end] == nums[end - 1]) end--;
                    res.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    begin++;
                    end--;
                } else {
                    end--;
                }
            }

        }
        return res;
    }


    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {};
        int[] nums3 = {0, 0, 0, 1};
        int[] nums4 = {1, 2, -2, -1};
        int[] nums5 = {-2, 0, 0, 2};
        int[] nums6 = {-2, 0, 1, 1, 2};
        int[] nums7 = {-2, 0, -1, -1, 2};
        System.out.println(threeSum(nums7));
    }
}
