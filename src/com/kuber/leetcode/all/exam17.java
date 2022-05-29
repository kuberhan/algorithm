package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class exam17 {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>();
        if (digits.length() == 0 || len > 4) return res;
        String path = "";
        dfs(len, 0, path, res, chars);
        return res;
    }

    public void dfs(int n, int depth, String path, List<String> res, char[] chars) {
        if (path.length() == n) {
            res.add(path);
            return;
        }

        if (chars[depth] == '2') {
            dfs(n, depth + 1, path + "a", res, chars);
            dfs(n, depth + 1, path + "b", res, chars);
            dfs(n, depth + 1, path + "c", res, chars);
        } else if (chars[depth] == '3') {
            dfs(n, depth + 1, path + "d", res, chars);
            dfs(n, depth + 1, path + "e", res, chars);
            dfs(n, depth + 1, path + "f", res, chars);
        } else if (chars[depth] == '4') {
            dfs(n, depth + 1, path + "g", res, chars);
            dfs(n, depth + 1, path + "h", res, chars);
            dfs(n, depth + 1, path + "i", res, chars);
        } else if (chars[depth] == '5') {
            dfs(n, depth + 1, path + "j", res, chars);
            dfs(n, depth + 1, path + "k", res, chars);
            dfs(n, depth + 1, path + "l", res, chars);
        } else if (chars[depth] == '6') {
            dfs(n, depth + 1, path + "m", res, chars);
            dfs(n, depth + 1, path + "n", res, chars);
            dfs(n, depth + 1, path + "o", res, chars);
        } else if (chars[depth] == '7') {
            dfs(n, depth + 1, path + "p", res, chars);
            dfs(n, depth + 1, path + "q", res, chars);
            dfs(n, depth + 1, path + "r", res, chars);
            dfs(n, depth + 1, path + "s", res, chars);
        } else if (chars[depth] == '8') {
            dfs(n, depth + 1, path + "t", res, chars);
            dfs(n, depth + 1, path + "u", res, chars);
            dfs(n, depth + 1, path + "v", res, chars);
        } else {
            dfs(n, depth + 1, path + "w", res, chars);
            dfs(n, depth + 1, path + "x", res, chars);
            dfs(n, depth + 1, path + "y", res, chars);
            dfs(n, depth + 1, path + "z", res, chars);
        }



        /*for (int i = depth; i < chars.length; i++) {
            if (chars[i] == '2') {
                dfs(n, depth + 1, path + "a", res, chars);
                dfs(n, depth + 1, path + "b", res, chars);
                dfs(n, depth + 1, path + "c", res, chars);
            } else if (chars[i] == '3') {
                dfs(n, depth + 1, path + "d", res, chars);
                dfs(n, depth + 1, path + "e", res, chars);
                dfs(n, depth + 1, path + "f", res, chars);
            } else if (chars[i] == '4') {
                dfs(n, depth + 1, path + "g", res, chars);
                dfs(n, depth + 1, path + "h", res, chars);
                dfs(n, depth + 1, path + "i", res, chars);
            } else if (chars[i] == '5') {
                dfs(n, depth + 1, path + "j", res, chars);
                dfs(n, depth + 1, path + "k", res, chars);
                dfs(n, depth + 1, path + "l", res, chars);
            } else if (chars[i] == '6') {
                dfs(n, depth + 1, path + "m", res, chars);
                dfs(n, depth + 1, path + "n", res, chars);
                dfs(n, depth + 1, path + "o", res, chars);
            } else if (chars[i] == '7') {
                dfs(n, depth + 1, path + "p", res, chars);
                dfs(n, depth + 1, path + "q", res, chars);
                dfs(n, depth + 1, path + "r", res, chars);
                dfs(n, depth + 1, path + "s", res, chars);
            } else if (chars[i] == '8') {
                dfs(n, depth + 1, path + "t", res, chars);
                dfs(n, depth + 1, path + "u", res, chars);
                dfs(n, depth + 1, path + "v", res, chars);
            } else {
                dfs(n, depth + 1, path + "w", res, chars);
                dfs(n, depth + 1, path + "x", res, chars);
                dfs(n, depth + 1, path + "y", res, chars);
                dfs(n, depth + 1, path + "z", res, chars);
            }
        }*/

    }

    @Test
    public void test() {
        List<String> strings = letterCombinations("");
        System.out.println(strings);
    }
}
