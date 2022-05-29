package com.kuber.leetcode.swordtooffer;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*剑指 Offer 59 - II. 队列的最大值*/
public class exam59_2 {

    /*
    解题思路：
        普通队列queue1负责正常出队入队
        双端队列queue2负责维护当前最大值，比最后一个小直接进队；如果队列的最后一个比要进队的小，就把比要进队小的值全部
        出队，要进队的进队
     */

    Queue<Integer> queue1;
    Deque<Integer> queue2;
    public exam59_2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int max_value() {
        if (queue2.isEmpty()) return -1;
        return queue2.peekFirst();
    }

    public void push_back(int value) {
        queue1.offer(value);
        while (!queue2.isEmpty() && queue2.peekLast() < value){
            queue2.pollLast();
        }
        queue2.offerLast(value);
    }

    public int pop_front() {
        if (queue1.isEmpty()) return -1;
        if (queue1.peek().equals(queue2.peek())){
            queue2.pollFirst();
        }
        return queue1.poll();
    }
}
