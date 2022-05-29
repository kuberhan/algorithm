package com.kuber.leetcode.swordtooffer;


/*剑指 Offer 24. 反转链表*/
public class exam24 {

    /*头插法*/
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode tail = head;
        while (tail.next != null){
            ListNode move = tail.next;
            tail.next = move.next;
            move.next = head;
            head = move;
        }
        return head;
    }

    /*双指针*/
    public ListNode reverseList2(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        while (right != null){
            ListNode tmp = right;
            right = right.next;
            tmp.next = left;
            left = tmp;
        }
        return left;
    }
}
