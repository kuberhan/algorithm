package com.kuber.leetcode.swordtooffer;


/*剑指 Offer 52. 两个链表的第一个公共节点*/
/*160. 相交链表*/
public class exam52 {

    /*双指针，浪漫相遇，我切亲的称之为：你走过她走过的路，才能相遇*/
    /*也可hashset做，不过空间复杂度O(n)，这个O(1),时间复杂度都一样，O(M+N)*/
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode temA = headA, temB = headB;
        while (headA != headB){//无交集，最后headA = headB = null跳出循环
            headA = headA != null ? headA.next : temB;
            headB = headB != null ? headB.next : temA;
        }
        return headA;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temA = headA, temB = headB;
        boolean flagA = false, flagB = false;
        while (headA != null && headB != null){
            if (headA == headB) return headA;
            headA = headA.next;
            if (headA == null && !flagA){
                headA = temB;
                flagA = true;
            }
            headB = headB.next;
            if (headB == null && !flagB){
                headB = temA;
                flagB = true;
            }
        }
        return null;
    }

}
