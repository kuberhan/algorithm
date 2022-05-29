package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

import java.util.ArrayList;

/*剑指 Offer 62. 圆圈中最后剩下的数字*/
public class exam62 {

    /*动态维护一个数组来做，效率非常差*/
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            path.add(i);
        }
        int mark = m % path.size() - 1;
        for (int i = 0; i < n - 1; i++) {
            path.remove(mark);
            mark = (mark + m - 1) % path.size();
        }
        return path.get(0);
    }

    /*动态规划，约瑟夫环问题*/
    public int lastRemaining2(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(lastRemaining2(5, 3));
    }
}
