package com.kuber.common;

public class KnapSack01 {
    /**
     * 解决背包问题的递归函数
     *
     * @param //w        物品的重量数组
     * @param //v        物品的价值数组
     * @param //index    当前待选择的物品索引
     * @param //capacity 当前背包有效容量
     * @return 最大价值
     */

    public static void main(String[] args) {
        int[] w = {3, 1, 2, 2};
        int[] v = {15, 8, 10, 15};
        System.out.println("该测试用例下的背包最大价值为："+knapSack01(w, v, 5));
    }

    public static int knapSack01(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        int[] dp = new int[C + 1];
        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[i] = w[0] <= i ? v[0] : 0;
        }

        for(int i = 1; i < size; i++){
            for(int j = C; j >= w[i]; j--){
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[C];
    }


}
