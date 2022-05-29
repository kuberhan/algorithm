package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 63. 股票的最大利润*/
public class exam63 {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxCost = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            maxCost = Math.max(maxCost, prices[i] - min);
        }
        return maxCost;
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE, maxCost = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            maxCost = Math.max(maxCost, price - min);
        }
        return maxCost;
    }

    @Test
    public void test(){
        int[] n = {2,4,1};
        System.out.println(maxProfit2(n));
    }
}
