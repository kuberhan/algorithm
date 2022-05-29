package com.kuber.leetcode.all;

public class exam61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;
        ListNode testLen = dummy;
        int len = 0;
        while (testLen.next != null) {//得到链表的长度
            testLen = testLen.next;
            ++len;
        }
        if (head != null) {//如果头节点不空 ，那么len不会为0
            if (k == 0 || k % len == 0) return dummy.next; //输入的k为0，或者k对len取余为0，那就把原链表返回
            for (int i = 0; i < (k % len); i++) {//双指针，这个是快指针，跟19题思路相似
                first = first.next;
            }
            while (first.next != null && second != null) {//second为慢指针，只要first.next不为空，那么second肯定不为空
                first = first.next;
                second = second.next;
            }
            dummy.next = second.next;//second节点为要作为新头节点的前一个节点，也是旋转后的链表的最后一个节点，second.next就作为新的头节点
            second.next = first.next;//first.next为空，那么最后一个节点second的下一个节点就为空
            first.next = head;//跟最初的头节点进行连接，就当作一个循环链表了
        }

        return dummy.next;
    }
}
