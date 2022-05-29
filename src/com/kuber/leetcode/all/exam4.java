package com.kuber.leetcode.all;

import org.junit.Test;

public class exam4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0){
            int left = find(nums1, 0, nums2, 0, total / 2);
            int right = find(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        }else return find(nums1, 0, nums2, 0, total / 2 + 1);
    }

    //k = (m + n) / 2;  m,n分别为nums1 nums2的长度  采用丢弃数组的方法
    public static int find(int[] nums1, int i, int[] nums2, int j, int k){
        if (nums1.length - i > nums2.length - j) //如果nums1长度比nums2大，则交换一下
            return find(nums2, j, nums1, i, k);
        if (k == 1){
            if (nums1.length == i) return nums2[j];
            else return Math.min(nums1[i], nums2[j]);
        }
        if(nums1.length == i) return nums2[j + k - 1];
        int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
        if (nums1[si - 1] > nums2[sj - 1])
            return find(nums1, i, nums2, sj, k - (sj - j));
        else return find(nums1, si, nums2, j, k - (si - i));
    }


    @Test
    public void test(){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
