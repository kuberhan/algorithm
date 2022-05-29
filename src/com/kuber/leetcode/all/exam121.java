package com.kuber.leetcode.all;

import org.junit.Test;

public class exam121 {
/*
思路还是挺清晰的，还是DP思想：
记录【今天之前买入的最小值】
计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
比较【每天的最大获利】，取最大值即可。3是这种解法
方法1，2是正常思路，从第一天开始，记录今天买入的花费，然后找到今天之后的最大值，最大值减去今天的值赋值给max，这种方法超时。
*/
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] - prices[i] <= max){
                    continue;
                }else {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int begin = 0;
        int max = 0;
        while (begin < len - 1){
            for (int i = begin; i < len; i++) {
                if (prices[i] - prices[begin] <= max){
                    continue;
                }else {
                    max = prices[i] - prices[begin];
                }
            }
            begin++;
        }

        return max;
    }

    public int maxProfit3(int[] prices) {
        int max = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i-1]);
            max = Math.max(max,prices[i] - min);
        }
        return max;
    }

    @Test
    public void test(){
        int[] p = {7,1,5,3,6,4};
        System.out.println(maxProfit3(p));
    }
}
