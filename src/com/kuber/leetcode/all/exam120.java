package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class exam120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] path = new int[row + 1][row + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                path[i][j] = triangle.get(i).get(j) + Math.min(path[i + 1][j], path[i + 1][j + 1]);
            }
        }
        return path[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] path = new int[row + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                path[j] = triangle.get(i).get(j) + Math.min(path[j], path[j + 1]);
            }
        }
        return path[0];
    }

    @Test
    public void test(){
        List<Integer> a1 = new ArrayList<>();
        a1.add(2);
        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        List<Integer> a3 = new ArrayList<>();
        a3.add(6);
        a3.add(5);
        a3.add(7);
        List<Integer> a4 = new ArrayList<>();
        a4.add(4);
        a4.add(1);
        a4.add(8);
        a4.add(3);
        List<List<Integer>> a = new ArrayList<>();
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        System.out.println(a);
        System.out.println(minimumTotal2(a));
    }

}
