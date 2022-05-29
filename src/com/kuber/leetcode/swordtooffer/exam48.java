package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/*剑指 Offer 48. 最长不含重复字符的子字符串*/
public class exam48 {

    /*双指针+hashmap*/
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){ //如果包含的话，就进行left指针的调整
                left = Math.max(left, map.get(s.charAt(i)));//调整的left永远只能往右取
                //left = map.get(s.charAt(i));  abba
            }
            map.put(s.charAt(i), i);//重复的key对应的v的值会被重写
            max = Math.max(max, i - left);
        }
        return max;
    }

    /*动态规划+hashmap*/
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        return max;
    }

    @Test
    public void test(){
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
