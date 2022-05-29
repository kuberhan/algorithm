package com.kuber.leetcode.all;


/*203. 移除链表元素*/
public class exam203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1, head);
        ListNode temp = newHead;
        while (head != null){
            if (head.val == val){
                temp.next = head.next;
                head = head.next;
            }else {
                temp = temp.next;
                head = head.next;
            }
        }
        return newHead.next;
    }
}
