package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.HashMap;

public class exam1 {

    /*hashmap*/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    @Test
    public void test(){
        int[] nums = {3,3};
        int[] ints = twoSum(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
