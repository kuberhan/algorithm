package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class exam77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0,  n, k, path, res);
        return res;
    }

    public void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < n; i++) {
            path.addLast(i + 1);
            dfs(i + 1, n, k, path, res);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = combine(4, 2);
        System.out.println(lists);
    }
}
