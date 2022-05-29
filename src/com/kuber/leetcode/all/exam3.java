package com.kuber.leetcode.all;


import org.junit.Test;

import java.util.HashMap;

/*3. 无重复字符的最长子串*/
public class exam3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i - left);
        }
        return max;
    }

    @Test
    public void test(){
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
