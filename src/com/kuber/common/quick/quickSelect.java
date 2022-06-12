package com.kuber.common.quick;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quickSelect {
    public static int quickSelectK(int[] nums, int left, int right, int k){
        if (left == right) return nums[left];
        int x = nums[(left + right) >> 1];
        int i = left - 1, j = right + 1;
        while (i < j){
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //位置对比（个数对比）
        int sl = j - left + 1;
        if (k <= sl) return quickSelectK(nums, left, j, k);
        return quickSelectK(nums, j + 1, right, k - sl);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] row1 = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(row1[0]);
        int k = Integer.parseInt(row1[1]);
        int[] nums = new int[n];
        String[] row2 = bufferedReader.readLine().split(" ");

        //System.out.println(row1.length + " " + row2.length);
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(row2[i]);
        }

        int res = quickSelectK(nums, 0, n - 1, k);

        System.out.println(res);
        bufferedReader.close();
    }

    /*    public static void main(String[] args) {
        int[] nums = {4, 1, 5, 2, 3};
        int n = 5;
        int k = 3;
        System.out.println(quickSelectK(nums, 0, n - 1, k));
    }*/
}
