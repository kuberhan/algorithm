package com.kuber.leetcode.nowdoder;

import org.junit.Test;

import java.util.ArrayList;

public class NC119 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || input.length == 0 || k == 0) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        return getPartition(input, 0, input.length - 1, k, res);


    }

    public ArrayList<Integer> getPartition(int[] input, int begin, int end, int k, ArrayList<Integer> res) {
        int par = partition(input, begin, end);
        if (par == k - 1) {
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
            return res;
        }
        return par > k - 1 ? getPartition(input, begin, par - 1, k, res) : getPartition(input, par + 1, end, k, res);
    }

    public int partition(int[] input, int begin, int end) {
        int mark = input[begin];
        while (begin < end) {
            while (begin < end && input[end] >= mark ) {
                end--;
            }
            input[begin] = input[end];
            while (begin < end && input[begin] <= mark ) {
                begin++;
            }
            input[end] = input[begin];
        }
        input[begin] = mark;
        return begin;
    }

    @Test
    public void test() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 5);
        System.out.println(res);
    }
}
