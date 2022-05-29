package com.kuber.leetcode.all;

public class exam19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newList = new ListNode(0,head);
        ListNode first = head;
        ListNode second = newList;
        int len = 0;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return newList.next;
    }
}
