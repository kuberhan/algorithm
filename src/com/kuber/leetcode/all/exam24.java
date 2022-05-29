package com.kuber.leetcode.all;

public class exam24 {

    public ListNode swapPairs(ListNode head) {
        ListNode newList = new ListNode(0,head);
        ListNode temp = newList;
        newList.next = head.next;
        ListNode first;
        ListNode second;
        while (temp.next != null && temp.next.next != null) {
            first = temp.next;
            second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp = first;
        }
        return newList.next;
    }
}
