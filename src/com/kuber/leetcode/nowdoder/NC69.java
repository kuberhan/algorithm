package com.kuber.leetcode.nowdoder;

public class NC69 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if (k == 0) return null;
        ListNode left = pHead, right = pHead;
        int i = 0;
        while (i < k - 1 && right != null){
            i++;
            right = right.next;
            if (right == null){
                return null;
            }
        }
        while (right != null && right.next != null){
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
