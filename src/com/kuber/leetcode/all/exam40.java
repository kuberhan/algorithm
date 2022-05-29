package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.*;

public class exam40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if(len == 0) return res;
        Arrays.sort(candidates);//排序是剪枝关键
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(len, 0,target, path, candidates,res);
        return res;
    }

    public void dfs(int len, int depth, int target, Deque<Integer> path, int[] candidates, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = depth; i < len; i++) {
            if(target - candidates[i] < 0) break;//剪大枝
            if(i > depth && candidates[i] == candidates[i-1]) continue;//这里是剪枝关键，剪小枝
            path.addLast(candidates[i]);
            dfs(len, i+1,target - candidates[i], path, candidates, res);
            path.removeLast();
        }

    }

    @Test
    public void test(){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
