package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 58 - II. 左旋转字符串*/
public class exam58_2 {

    /*StringBuilder实现*/
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /*StringBuilder优化实现*/
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = n; i < len + n; i++) {
            sb.append(s.charAt(i % len));
        }
        return sb.toString();
    }

    public String reverseLeftWords3(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s,n,s.length());
        sb.append(s,0,n);
        return sb.toString();
    }

    @Test
    public void test(){
        String s = "lrloseumgh";
        System.out.println(reverseLeftWords3(s, 6));
    }
}
