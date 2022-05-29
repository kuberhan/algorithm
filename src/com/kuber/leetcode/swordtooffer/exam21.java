package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 21. 调整数组顺序使奇数位于偶数前面*/
public class exam21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length && left < nums.length){
            while (left < nums.length && nums[left] % 2 != 0){
                left++;
            }
            while (right < nums.length && nums[right] % 2 == 0 ){
                right++;
            }
            if (left < right && left < nums.length && right < nums.length){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        return nums;
    }

    /*快慢指针，慢指针永远指向从左向右的第一个偶数，快指针指向遇到的第一个奇数*/
    public int[] exchange2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] % 2 == 1){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
        return nums;
    }

    /*头尾双指针,左指针指向偶数，右指针指向奇数,两个指针向中间靠拢*/
    public int[] exchange3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            if (nums[left] % 2 == 0 && nums[right] % 2 == 1){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            if (nums[left] % 2 == 1){

                left++;
            }
            if (nums[right] % 2 == 0){
                right--;
            }
        }
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {2,4};
        int[] res = exchange3(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
