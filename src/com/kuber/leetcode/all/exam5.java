package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class exam5 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1, right = i + 1;//回文串为奇数个
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if (res.length() < right - left - 1) res = s.substring(left + 1, right);

            int left2 = i, right2 = i + 1;
            while (left2 >=0 && right2 < s.length() && s.charAt(left2) == s.charAt(right2)){
                left2--;
                right2++;
            }
            if (res.length() < right2 - left2 - 1) res = s.substring(left2 + 1, right2);
        }
        return res;
    }


    @Test
    public void test(){

        String s = longestPalindrome("aadaape");
        System.out.println(s);
    }
}
