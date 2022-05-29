package com.kuber.leetcode.all;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/*242. 有效的字母异位词*/
public class exam242 {

    /*方法一最好想，变成字符数组，然后排序，再对每个位子进行比较*/
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        for (int i = 0; i < s.length(); i++) {
            if (chars1[i] != chars2[i]) return false;
        }
        return true;
    }

    /*方法二，hashmap*/
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) < 0) return false;
        }
        return true;
    }

    /*方法三*/
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] res = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            --res[t.charAt(i) - 'a'];
            if(res[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isAnagram3("anagram", "nagaram"));
    }
}
