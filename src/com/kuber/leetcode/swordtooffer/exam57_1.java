package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 57. 和为s的两个数字*/
public class exam57_1 {

    /*左右指针分别从头和从末尾往中间靠，若left+right所指数据之和小于target，则left+1；否则right-1*/
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //nums中比target还大的数直接过滤掉
        while (nums[right] > target){
            right--;
        }
        while (left < right){
            if (nums[left] + nums[right] == target){
                return new int[]{nums[left], nums[right]};
            }else if (nums[left] + nums[right] < target){
                left++;
            }else {
                right--;
            }
        }
        return new int[0];
    }

    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        int[] res = twoSum(nums, 9);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
