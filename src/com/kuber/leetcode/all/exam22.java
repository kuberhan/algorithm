package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class exam22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        DFS(n, "", res, 0, 0);

        return res;
    }

    public void DFS(int n, String path, List<String> res, int left, int right) {
        if (left > n || right > left) return;

        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        DFS(n, path + "(", res, left + 1, right);
        DFS(n, path + ")", res, left, right + 1);
    }


    @Test
    public void test() {
        List<String> strings = generateParenthesis(2);
        System.out.println(strings);
    }
}
