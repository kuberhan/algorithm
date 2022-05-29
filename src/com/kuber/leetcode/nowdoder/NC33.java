package com.kuber.leetcode.nowdoder;

public class NC33 {

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode move = new ListNode(0);
        ListNode head = move;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                move.next = l1;
                l1 = l1.next;
            }else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }
        move.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
