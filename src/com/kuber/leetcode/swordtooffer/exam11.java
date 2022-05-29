package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

/*剑指 Offer 11. 旋转数组的最小数字*/
public class exam11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        int mid;
        while (right - left > 1) {
            mid = (left + right) / 2;
            if (numbers[mid] < numbers[left]) right = mid;
            else if (numbers[mid] > numbers[right]) left = mid;
            //这个条件是解决numbers[mid] == numbers[left] && numbers[mid] == numbers[left]这种情况的
            else if (numbers[mid] == numbers[left] && numbers[mid] == numbers[left]){
                left++;
                right--;
            }
            else return numbers[left]; //如果不满足上面两种，说明已经有序，就返回left
        }
        return Math.min(numbers[left], numbers[right]);
    }

    @Test
    public void test() {
        int[] nums = {3,1};
        System.out.println(minArray(nums));
    }
}
