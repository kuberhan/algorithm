package com.kuber.leetcode.swordtooffer;

import java.util.Stack;

public class exam09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public exam09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    /*
    stack1作为队尾，stack2作为队头出栈
    第一个栈stack1负责进栈，
    第二个栈stack2为空的时候，并且stack1也为空的时候，直接返回-1；
                            stack1不为空的时候，将stack1中的数据全部出栈，让其进入stack2
           stack2不为空的时候，直接出栈
     */
    public int deleteHead() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()){
                stack2.push(stack2.pop());
            }
        }
        return stack2.pop();
    }
}
