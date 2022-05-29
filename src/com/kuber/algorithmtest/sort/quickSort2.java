package com.kuber.algorithmtest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
* https://www.acwing.com/activity/content/code/content/487415/
*  搞清楚边界问题
* */
public class quickSort2 {

    public static void quickSort(int[] nums, int l, int r){
        if(l >= r) return;
        int x = nums[(l + r + 1) / 2], i = l - 1, j = r + 1;
        while (i < j){
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort(nums, l, i - 1);
        quickSort(nums, i, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);
        int[] nums = new int[n];
        String[] split = bufferedReader.readLine().split(" ");

        //System.out.println(split.length);
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        quickSort(nums, 0, n - 1);

        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[n - 1]);
        bufferedReader.close();
    }
}
