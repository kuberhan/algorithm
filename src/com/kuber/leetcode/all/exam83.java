package com.kuber.leetcode.all;

public class exam83 {

    public ListNode deleteDuplicates(ListNode head) {//这个用时多，
        ListNode newList = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = newList.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                if (slow.val == fast.val) continue;
            }
            slow.next = fast;
            slow = slow.next;
        }
        return newList.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {//这个用时更少，但是更耗内存
        ListNode newList = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = newList.next;
        if(head != null){
            while (fast.next != null) {
                fast = fast.next;
                if (slow.val == fast.val) continue;
                slow.next = fast;
                slow = slow.next;
            }
            slow.next = fast.next;
        }

        return newList.next;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.val == current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
