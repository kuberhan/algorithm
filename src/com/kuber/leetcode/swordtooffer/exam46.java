package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 46. 把数字翻译成字符串*/
public class exam46 {


    /*dp,空间复杂度O(1)*/
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int left = 1, right = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int t = tmp.compareTo("10")>=0 && tmp.compareTo("25") <=0 ? left + right : right;
            /*if (tmp.compareTo("10")>=0 && tmp.compareTo("25") <=0){
                t = left + right;
            }else {
                t = right;
            }*/
            left = right;
            right = t;
        }
        return right;
    }

    /*dp,空间复杂度O(n)*/
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            dp[i] = tmp.compareTo("10")>=0 && tmp.compareTo("25") <=0 ? dp[i - 2] + dp[i - 1] : dp[i - 1];
        }
        return dp[s.length()];
    }

    @Test
    public void test(){
        System.out.println(translateNum2(12258));
    }
}
