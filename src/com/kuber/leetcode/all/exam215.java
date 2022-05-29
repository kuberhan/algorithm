package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*215. 数组中的第K个最大元素*/
public class exam215 {

    /*方法一：堆排序，建立大根堆*/
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            if (pq.size() < (nums.length - k + 1)){
                pq.offer(num);
            }else if (pq.peek() > num){
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }

    /*方法二：快速排序*/
    public int findKthLargest2(int[] nums, int k) {
        return quickSearch(nums, 0, nums.length - 1, k );
    }

    public int quickSearch(int[] nums, int low, int high, int k){
        int par = partition(nums, low, high);
        if (par == (nums.length - k)) return nums[par];
        return par > (nums.length - k) ? quickSearch(nums, low, par - 1, k) : quickSearch(nums, par + 1, high, k);
    }

    /*递减快排*/
    public int partition(int[] nums, int low, int high){
        int i = low, j = high + 1;
        int key = nums[low];
        while (true){
            while (++i <= high && nums[i] < key);
            while (--j >= low && nums[j] > key);
            if (i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[low] = nums[j];
        nums[j] = key;
        return j;
    }

    /*手动建堆*/




    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest2(nums, 2));
    }
}
