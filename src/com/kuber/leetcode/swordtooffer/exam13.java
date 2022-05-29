package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

/*剑指 Offer 13. 机器人的运动范围*/
public class exam13 {

    /*回溯解体套路，将矩阵抽象成多叉树*/
    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        return dfs(map, 0, 0, m, n, k);
    }

    public int dfs(int[][] map, int x, int y, int m, int n, int k) {
        if (!isGrid(x, y, m, n, k)) return 0;
        if (map[x][y] == 1) return 0;
        map[x][y] = 1;
        return 1 + dfs(map, x, y - 1, m, n, k)
                + dfs(map, x, y + 1, m, n, k)
                + dfs(map, x - 1, y, m, n, k)
                + dfs(map, x + 1, y, m, n, k);

    }

    public boolean isGrid(int x, int y, int m, int n, int k) {
        return x >= 0 && x < m && y >= 0 && y < n && (bitSum(x) + bitSum(y) <= k);
    }

    public int bitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(movingCount(2,3,1));


        /*System.out.println(bitSum(23));*/
    }
}
