package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exam90_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int depth, int[] nums, List<Integer> sub, List<List<Integer>> res) {
        res.add(new ArrayList<>(sub));
        for (int i = depth; i < nums.length; i++) {
            if (i > depth && nums[i] == nums[i - 1]) continue;
            sub.add(nums[i]);
            dfs(i + 1, nums, sub, res);
            sub.remove(sub.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }
}
