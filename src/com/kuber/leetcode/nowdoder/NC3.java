package com.kuber.leetcode.nowdoder;

public class NC3 {
    public ListNode detectCycle(ListNode head) {
        ListNode left = head, right = head;
        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
            if(left == right){
                right = head;
                break;
            }
        }
        if(right == null || right.next == null) return null;
        while(left != right){
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
