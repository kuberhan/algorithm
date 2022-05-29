package com.kuber.leetcode.all;


import org.junit.Test;

/*283. 移动零*/
public class exam283 {

    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length - zeroCount; i++) {
            boolean flag =false;
            for (int j = 0; j < nums.length - zeroCount - 1; j++) {
                if (nums[j] == 0) {
                    flag = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (flag) zeroCount++;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void moveZeroes2(int[] nums) {
        int left= 0, right = 0;
        while (right < nums.length){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    @Test
    public void test(){
        int[] n = {0,1,0,3,12};
        moveZeroes2(n);
    }
}
