package com.kuber.leetcode.swordtooffer;

import java.util.LinkedList;

/*剑指 Offer 25. 合并两个排序的链表*/
public class exam25 {

    /*创建个新节点，新生成一个链表即可*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resL = new ListNode(-1);
        ListNode move = resL;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                move.next = l1;
                move = move.next;
                l1 = l1.next;
            } else {
                move.next = l2;
                move = move.next;
                l2 = l2.next;
            }
        }
        move.next = (l1 == null ? l2 : l1);
        return resL.next;
    }
}
