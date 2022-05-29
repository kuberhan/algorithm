package com.kuber.leetcode.all;

import com.kuber.leetcode.all.ListNode;

import java.util.ArrayList;
import java.util.List;

/*234. 回文链表*/
public class exam234 {

    /*快慢指针+栈*/
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        List<ListNode> list = new ArrayList<>();
        while (fast != null && fast.next != null) {
            list.add(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast != null && fast.next == null) {
            if (fast != null && fast.next == null) slow = slow.next;
            while (slow != null) {
                if (list.remove(list.size() - 1).val != slow.val) return false;
                slow = slow.next;
            }
        }
        return true;
    }

    /*快慢指针+头插法(反转前半部分/后半部分)*/
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode tem = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;//快指针先走，否则slow前半部分会变化
            if (fast == null) break;
            //头插，逆转前半部分，头插法需要三个指针！
            head = slow.next;
            slow.next = head.next;
            head.next = tem;
            tem = head;
        }
        if (fast != null) head = head.next;//奇数
        slow = slow.next;
        while (slow != null) {
            if (head.val != slow.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
