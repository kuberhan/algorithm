package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*剑指 Offer 57 - II. 和为s的连续正数序列*/
public class exam57_2 {

    /*
    滑动窗口解法：双指针规定窗口范围
    左右指针都只能往右移动
    [left,right]区间的和小于target时，right就往右走一位；大于target时，left就往右走一位；相等就添加
    */
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (left <= target / 2){
            if (sum < target){
                sum += right;
                right++;
            }else if (sum > target){
                sum -= left;
                left++;
            }else {
                int[] path = new int[right - left];
                for (int i = 0; i < path.length; i++) {
                    path[i] = left + i;
                }
                res.add(path);
                sum += right;
                right++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test(){
        int[][] res = findContinuousSequence(9);
        for (int[] ints : res) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
