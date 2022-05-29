package com.kuber.leetcode.all;

import org.junit.Test;

/*
 * 做这道题之前，要想清楚：
 * 一旦车不能从x到y的话，那么在区间内的任意站到y都不可能到达了，也就意味着，这个区间内的任意点都不能作为起点去走完一个循环，
 * 那么自然而然，O(n)的解法就出来了
 * 结论1：如果 left 累加 gas[i]-cost[i]后，小于 0。则出发点begin到站 i 都不是起点。
 * 结论2：如果总加油量 sum(gas) >= sum(cost) 总耗油量，问题一定有解。
 * */
public class exam134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int leftGas = -1;
        for (int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                leftGas = 0;
                for (int j = i; j < len; j++) {
                    if (leftGas >= 0) {
                        leftGas += gas[j];
                        leftGas -= cost[j];
                    }
                }
                for (int j = 0; j < i + 1; j++) {
                    if (leftGas >= 0) {
                        leftGas += gas[j];
                        leftGas -= cost[j];
                    }
                }
            }
            if (leftGas >= 0) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int leftGas = -1;
        for (int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                leftGas = 0;
                for (int j = i; j < len + i; j++) {
                    if (leftGas >= 0) {
                        leftGas += gas[j % len];
                        leftGas -= cost[j % len];
                    } else {
                        j = len + i - 1;
                    }
                }
            }
            if (leftGas >= 0) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;
        while (i < len) {
            int leftGas = 0;
            int j = 0;
            while (j < len) {
                leftGas += gas[(j + i) % len];
                leftGas -= cost[(j + i) % len];
                if (leftGas < 0) {
                    break;
                }
                j++;
            }
            if (leftGas >= 0) {
                return i;
            } else {
                i = i + j + 1;
            }
        }
        return -1;
    }

    //这种解法就用到了上面两个结论，非常方便
    public int canCompleteCircuit4(int[] gas, int[] cost) {
        int len = gas.length;
        int leftGas = 0;
        int begin = 0;
        int sumGas = 0, sumCost = 0;
        for (int i = 0; i < len; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            leftGas += gas[i] - cost[i];
            if (leftGas < 0) {
                begin = i + 1;
                leftGas = 0;
            }
        }
        return sumGas < sumCost ? -1 : begin;//总油量不够，问题无解
    }

    @Test
    public void test() {
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        int[] gas2 = {1, 2, 3, 4, 5};
        int[] cost2 = {3, 4, 5, 1, 2};
        int[] gas3 = {2, 3, 4};
        int[] cost3 = {3, 4, 3};
        int[] gas4 = {4, 5, 2, 6, 5, 3};
        int[] cost4 = {3, 2, 7, 3, 2, 9};
        System.out.println(canCompleteCircuit4(gas, cost));
    }
}
