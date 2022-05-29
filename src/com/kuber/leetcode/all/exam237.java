package com.kuber.leetcode.all;

import com.kuber.leetcode.all.ListNode;

public class exam237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
