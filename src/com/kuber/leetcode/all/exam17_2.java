package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.*;

public class exam17_2 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0 || len > 4) return res;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        dfs(0, new StringBuilder(), digits, phoneMap, res);
        return res;
    }

    public void dfs(int depth, StringBuilder path, String digits, Map<Character, String> phoneMap, List<String> res) {
        if (path.length() == digits.length()) {
            res.add(path.toString());//path用来存储生成树的一条路径
            return;
        }

        String letter = phoneMap.get(digits.charAt(depth));
        for (int i = 0; i < letter.length(); i++) {
            dfs(depth + 1, path.append(letter.charAt(i)), digits, phoneMap, res);
            path.deleteCharAt(depth);
        }


    }

    @Test
    public void test() {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }
}
