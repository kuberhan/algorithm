package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class exam22_2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        DFS(n, new StringBuilder(), res, 0, 0);

        return res;
    }

    public void DFS(int n, StringBuilder path, List<String> res, int left, int right) {
        if (left > n || right > left) return;

        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        DFS(n, path.append("("), res, left + 1, right);
        path.deleteCharAt(path.length() - 1);
        DFS(n, path.append(")"), res, left, right + 1);
        path.deleteCharAt(path.length() - 1);
    }


    @Test
    public void test() {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
}
