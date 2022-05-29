package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.*;

public class exam349 {

    /*hashmap解决*/
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int mark = nums1[i];
            /*if (!map.containsKey(mark)) {
                map.put(mark, 0);
            }*/
            map.put(mark, 1);
        }
        int j = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /*hashset解决*/
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            map.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.contains(nums2[i])) {
                list.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[] n1 = {4,9,5};
        int[] n2 = {9,4,9,8,4};
        int[] res = intersection2(n1, n2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
