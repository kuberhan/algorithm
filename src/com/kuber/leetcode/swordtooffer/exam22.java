package com.kuber.leetcode.swordtooffer;

public class exam22 {

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right != null){
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
