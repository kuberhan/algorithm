package com.kuber.leetcode.all;

import com.kuber.leetcode.all.ListNode;

import java.util.HashSet;

/*160. 相交链表*/
public class exam160 {
    /*hash表*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> map = new HashSet<>();
        while (headA != null){
            map.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(!map.add(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    /*双指针，走完自己的路再走另一条路*/
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode markA = headA;
        ListNode markB = headB;
        while (headA != headB){
            if (headA != null) headA = headA.next;
            else headA = markB;
            if (headB != null)  headB = headB.next;
            else headB = markA;
        }
        return headA;
    }
}
