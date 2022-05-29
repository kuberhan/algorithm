package com.kuber.leetcode.all;

import com.kuber.leetcode.all.ListNode;

import java.util.HashSet;
import java.util.Set;

/*142. 环形链表 II*/
public class exam142 {

    /*方法一：hashset解决*/
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> map = new HashSet<>();
        while (head != null){
            if(!map.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /*方法二：龟兔赛跑算法改进*/

    /**
     * 设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b的距离与fast 相遇。此时，fast 指针已经走完了环的 n 圈，
     * 因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc
     *根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 22 倍。因此，我们有
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * 有了 a=c+(n-1)(b+c)的等量关系，我们会发现：从相遇点到入环点的距离加上n-1圈的环长，恰好等于从链表头部到入环点的距离。
     *因此，当发现slow 与fast 相遇时，我们再额外使用一个指针ptr。起始，它指向链表头部；随后，它和slow 每次向后移动一个位置。
     * 最终，它们会在入环点相遇。
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode third = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != third){
                    slow = slow.next;
                    third = third.next;
                }
                return slow;
            }
        }
        return null;
    }
}
