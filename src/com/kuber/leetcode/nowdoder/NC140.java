package com.kuber.leetcode.nowdoder;

import org.junit.Test;

public class NC140 {
    public int[] MySort(int[] arr) {
        // write code here
        getPartition(arr, 0 , arr.length - 1);
        return arr;
    }

    public void getPartition(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int par = partition(arr, begin, end);
        getPartition(arr, begin, par - 1);
        getPartition(arr, par + 1, end);
    }

    public int partition(int[] arr, int begin, int end) {
        int parMark = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] >= parMark) {
                end--;
            }
            arr[begin] = arr[end];
            while (begin < end && arr[begin] <= parMark) {
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = parMark;
        return begin;
    }

    public int[] BubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (flag == false) break;
        }
        return arr;
    }

    /*归并排序*/
    public void mergeSort(int[] arr, int left, int right){
        if (left == right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);//归并排序前半段
        mergeSort(arr, mid + 1, right);//归并排序后半段
        merge(arr, left, mid, right);//将前后两段进行合并
    }

    //进行两个数组的归并
    public void merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //如果p1还未遍历完
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        //如果p2还未遍历完
        while (p2 <= right){
            help[i++] = arr[p2++];
        }
        //将辅助数组拷贝回原始数组
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }

    @Test
    public void test(){
        int[] a = {5,2,3,1,4};
        int[] res = MySort(a);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
        int[] ints = BubbleSort(a);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        mergeSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
