package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

/*剑指 Offer 58 - I. 翻转单词顺序*/
public class exam58_1 {
    /*双指针法*/
    public String reverseWords(String s) {
        int left = s.length() - 1, right = left;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && chars[left] == ' ') {
                left--;
                right--;
            }
            while (left >= 0 && chars[left] != ' ') {
                left--;
            }
            sb.append(chars, left + 1, right - left);
            sb.append(" ");
            right = left;
        }
        return sb.toString().trim();
    }

    @Test
    public void test() {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }
}
