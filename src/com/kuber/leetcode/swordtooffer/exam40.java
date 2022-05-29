package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*剑指 Offer 40. 最小的k个数*/
public class exam40 {

    /*堆排序*/
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        //默认小根堆，重写方法建成大根堆
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() > num) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        for (Integer num : pq) {
            res[i++] = num;
        }
        return res;
    }

    /*快速排序思想*/
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSearch(int[] arr, int low, int high, int k) {
        int par = partition(arr, low, high);
        if (par == k) {
            return Arrays.copyOf(arr, k + 1);
        }
        return par > k ? quickSearch(arr, low, par - 1, k) : quickSearch(arr, par + 1, high, k);
    }

    public int partition(int[] arr, int low, int high) {
        int i = low, j = high + 1;
        int parkey = arr[low];
        while (true) {
            while (++i <= high && arr[i] < parkey);
            while (--j >= low && arr[j] > parkey);
            if (i >= j) break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[low] = arr[j];
        arr[j] = parkey;
        return j;
    }

//    public int partition(int[] arr, int low, int high) {
//        int i = low, j = high;
//        int parkey = arr[i];
//        while (i < j) {
//            while (i < j && arr[j] >= parkey) {
//                j--;
//            }
//            arr[i] = arr[j];
//            while (i < j && arr[i] <= parkey) {
//                i++;
//            }
//            arr[j] = arr[i];
//        }
//        arr[i] = parkey;
//        return i;
//    }

    @Test
    public void test() {
        int[] n = {4, 5, 1, 6, 2, 7, 3};
        int[] n2 = {0, 1, 2, 1};
        int[] res = getLeastNumbers2(n, 4);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

}

