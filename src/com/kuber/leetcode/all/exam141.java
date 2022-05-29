package com.kuber.leetcode.all;

import com.kuber.leetcode.all.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*141. 环形链表*/
public class exam141 {

    /*我的解法，有点拉跨*/
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        while (head != null){
            if(map.containsKey(head)){
                return true;
            }
            map.put(head, true);
            head = head.next;
        }
        return false;
    }

    /*hashset解法*/
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> map = new HashSet<>();
        while (head != null){
            if(!map.add(head))  return true;
            head = head.next;
        }
        return false;
    }

    /*龟兔赛跑算法代码1,官方版*/
    public boolean hasCycle3(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick){
            if(quick == null || quick.next == null) return false;
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    /*龟兔赛跑算法代码2*/
    public boolean hasCycle4(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick) return true;
        }
        return false;
    }
}
