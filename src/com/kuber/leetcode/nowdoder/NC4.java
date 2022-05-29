package com.kuber.leetcode.nowdoder;



public class NC4 {
    public boolean hasCycle(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
            if(left == right) return true;
        }
        return false;
    }
}
