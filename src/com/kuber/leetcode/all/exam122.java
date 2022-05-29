package com.kuber.leetcode.all;

import org.junit.Test;

public class exam122 {

    public int maxProfit(int[] prices) {
        int begin = 0, end = 0;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i] > prices[i + 1]){
                end = i;
                sum += (prices[end] - prices[begin]);
                begin = i + 1;
                end = i + 1;
            }else {
                end = end + 1;
            }
        }
        sum += prices[end] - prices[begin];
        return sum;
    }
/*贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。*/
    public int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                sum += (prices[i] - prices[i-1]);
            }
        }
        return sum;
    }

    public int maxProfit3(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0,prices[i] - prices[i - 1]);
        }
        return sum;
    }


    @Test
    public void test(){
        int[] prices = {4,3,2,1};
        System.out.println(maxProfit3(prices));
    }
}
