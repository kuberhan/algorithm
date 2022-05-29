package com.kuber.leetcode.all;


import org.junit.Test;

public class exam8 {

    public int myAtoi(String s) {
        int index = 0;
        int minus = 1;
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        if (index == s.length()) return 0;

        if (s.charAt(index) == '-') {
            index++;
            minus = -1;
        }
        else if (s.charAt(index) == '+'){
            index++;
        }
        int res = 0;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            int temp = s.charAt(index) - '0';
            if (minus > 0 && (Integer.MAX_VALUE - temp) / 10 < res) return Integer.MAX_VALUE; //判断越界
            if (minus < 0 && (Integer.MIN_VALUE + temp) / 10 > -res) return Integer.MIN_VALUE;
            if (-res * 10 - temp == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            res = res * 10 + temp;
            index++;
        }
        return res * minus;
    }

    @Test
    public void test(){
        System.out.println(myAtoi("  -127sdfdas"));
        System.out.println(myAtoi("-3147483680add"));
        System.out.println("===========================");
        //System.out.println("MAX=  "+Integer.MAX_VALUE);
        //System.out.println("MIN=  "+Integer.MIN_VALUE);
    }
}
