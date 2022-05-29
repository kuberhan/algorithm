package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class exam78_2 {
    /*
    * 回溯解法
    * */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,nums,new ArrayList<>(),res);
        return res;
    }

    public void dfs(int depth, int[] nums, List<Integer> sub, List<List<Integer>> res){
        res.add(new ArrayList<>(sub));
        for (int i = depth; i < nums.length; i++) {
            sub.add(nums[i]);
            dfs(i+1,nums,sub,res);
            sub.remove(sub.size() - 1);
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }
}
