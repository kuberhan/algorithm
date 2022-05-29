package com.kuber.leetcode.all;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
* 这题需要再看看，理解不太深
* */
public class exam131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) return res;
        char[] chars = s.toCharArray();
        Deque<String> path = new ArrayDeque<>();
        dfs(chars, 0, len, path, res);
        return res;
    }

    public void dfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!checkPalindrome(chars, index, i)) continue;//如果前缀不是回文字符串，则不产生分支和结点

            path.addLast(new String(chars, index, i + 1 - index));//把切掉的前缀加到字符串队列中
            dfs(chars, i + 1, len, path, res);
            path.removeLast();
        }

    }

    public boolean checkPalindrome(char[] chars, int left, int right) {
        while (left < right){
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "aabb";
        List<List<String>> lists = partition(s);
        System.out.println(lists);
    }
}
