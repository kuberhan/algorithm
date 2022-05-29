package com.kuber.leetcode.all;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 56. 合并区间
 * */
public class exam56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {//重写方法
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < len){
            int left = intervals[i][0], right = intervals[i][1];
            while (i < len - 1 && intervals[i + 1][0] <= right){
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(merge[i][j]+" ");
            }
            System.out.println();
        }
    }
}
