package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.*;

public class exam47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        dfs(0, len, nums, used, path, res);
        return res;
    }

    public void dfs(int depth, int len, int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(depth + 1, len, nums, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }
}
