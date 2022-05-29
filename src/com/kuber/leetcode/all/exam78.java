package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
 * 这道题比较巧，不需要用回溯做
 * 思路如下：思路清晰了，解决起来特别简单
 * 可以直接从/前后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
 * */
public class exam78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();//所有子集
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {//用来获取新的数
            int size = res.size();
            for (int j = 0; j < size; j++) {//用来获取所有子集
                List<Integer> sub = new ArrayList<>(res.get(j));//获取所有子集
                sub.add(nums[i]);//所有子集都要加上遇到的新数,这就生成了一个新的子集sub
                res.add(sub);//将新生成的子集加到子集队列中
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
