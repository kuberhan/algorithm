package com.kuber.leetcode.swordtooffer;



import java.util.Stack;

/*剑指 Offer 06. 从尾到头打印链表*/
public class exam06 {

    /*方法一：改变链表结构，头插法*/
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ListNode tail = head;
        int len = 0;
        while (tail.next != null) {
            ListNode move = tail.next;
            tail.next = move.next;
            move.next = head;
            head = move;
            len++;
        }
        len++;
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            if (head != null) {
                res[i] = head.val;
                head = head.next;
            }
        }
        return res;
    }

    /*栈，这种做法没什么意思，时间复杂度O(n),空间复杂度也是O(n)*/
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        int len = stack.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
