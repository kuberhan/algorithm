package com.kuber.leetcode.all;


public class exam21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);//-1给不给都不影响，
        ListNode flag = l3;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                flag.next = l1;
                l1 = l1.next;
            } else {
                flag.next = l2;
                l2 = l2.next;
            }
            flag = flag.next;
        }
        flag.next = l1 == null ? l2 : l1;
        return l3.next;
    }
}
