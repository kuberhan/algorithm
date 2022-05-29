package com.kuber.leetcode.nowdoder;

public class NC73 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 0;
        int candidate = array[0];
        for (int num : array) {
            if (count == 0) candidate = num;
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}
