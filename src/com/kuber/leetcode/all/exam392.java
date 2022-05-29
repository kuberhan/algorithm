package com.kuber.leetcode.all;

import org.junit.Test;

public class exam392 {

    /*要处理下标越界*/
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        char[] ss = new char[s.length()+1];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            ss[i] = chars[i];
        }
        //System.arraycopy(chars,0,ss,0,s.length());
        char[] ts = t.toCharArray();
        int mark = 0;
        for (int i = 0; i < t.length(); i++) {
            if(ts[i] == ss[mark]){
                mark++;
            }
        }
        if (mark == s.length()) return true;
        else return false;
    }

    /*双指针不容易出现下标越界*/
    public boolean isSubsequence2(String s, String t) {
        int shorLen = s.length(),longLen = t.length();
        int i = 0, j = 0;
        while (i < shorLen && j < longLen){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == shorLen) return true;
        return false;
    }
    /*要处理下标越界的问题*/
    public boolean isSubsequence3(String s, String t) {
        if(s.length() == 0) return true;
        int mark = 0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(mark)){
                ++mark;
                if (mark == s.length()) return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        String s = "sadf", t = "";
        System.out.println(isSubsequence3(s, t));
    }
}
