package com.kuber.leetcode.swordtooffer;

public class exam18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode move = new ListNode(-1);
        move.next = head;
        while (move != null && move.next != null){
            if(move.next.val == val){
                move.next = move.next.next;
                break;
            }
            move = move.next;
        }
        return head;
    }
}
