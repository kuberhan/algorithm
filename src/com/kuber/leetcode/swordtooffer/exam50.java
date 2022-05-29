package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class exam50 {

    /*最简单的，hashmap做*/
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c :chars){
            map.put(c,map.containsKey(c));
        }
        for (char c : chars) {
            if (!map.get(c)) return c;
        }
        return ' ';
    }

    @Test
    public void test(){
        String s = "aadadaad";
        System.out.println(firstUniqChar(s));
    }
}
