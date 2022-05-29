package com.kuber.leetcode.all;

import com.kuber.leetcode.all.ListNode;

public class exam206 {

    public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode(0, head);
        ListNode flag;
        while (head != null && head.next != null) {
            flag = temp.next;
            temp.next = head.next;
            head.next = temp.next.next;
            temp.next.next = flag;
        }
        return temp.next;
    }
}
