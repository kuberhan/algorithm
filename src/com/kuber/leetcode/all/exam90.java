package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exam90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());//空集，也为子集
        int begin = 1;
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            if (i > 0 && nums[i] != nums[i - 1]) { //这里用迭代法，每次i和i-1不同，就会产生新解，记录要产生新解的位置
                begin = size;
            }
            for (int j = size - begin; j < size; j++) {

                List<Integer> sub = new ArrayList<>(res.get(j));
                sub.add(nums[i]);
                res.add(sub);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
