package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.*;

public class exam39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        //候选数组为0的话直接返回空集合
        if(len == 0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }
    /**
     * @param candidates 候选数组
     * @param begin      候选数组中的搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    public void dfs(int[] candidates,int begin,int len, int target, Deque<Integer> path, List<List<Integer>> res){
        //target为负数时不再产生孩子节点
        if(target < 0) return;
        //target为0的时候，证明该条路径正确，将路径添加到结果集中
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //因为每个候选数可重复选择，因此可一直深度
            path.addLast(candidates[i]);
            dfs(candidates,i,len,target - candidates[i],path,res);
            //生成路径最后一个路径到达的节点数不为0，则将path队列的末尾状态重置，深度遍历另一条路径
            path.removeLast();
        }
    }

    @Test
    public void test(){
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }

}
