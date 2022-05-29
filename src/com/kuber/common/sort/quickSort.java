package com.kuber.common.sort;

import java.io.*;
import java.io.IOException;
import java.util.Random;


/*
* 还有问题，暂未解决，采用方法2
* */
public class quickSort {

    public static void quickSort(int[] nums, int left, int right){
        if (left < right){
            int i = partition(nums, left, right)[0];
            int j = partition(nums, left, right)[1];
            quickSort(nums, left, j);
            quickSort(nums, i, right);
        }
    }

    public static int[] partition(int[] nums, int left, int right){
        int i = left, j = right;
        int x = left + new Random().nextInt(right - left + 1);
        while (i <= j){
            while (nums[i] < nums[x]) i++;
            while (nums[j] > nums[x]) j--;
            if (i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return new int[]{i, j};
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);
        int[] nums = new int[n];
        String[] split = bufferedReader.readLine().split(" ");

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
