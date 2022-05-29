package com.kuber.leetcode.swordtooffer;

import java.util.Stack;

/*剑指 Offer 30. 包含min函数的栈*/
public class exam30 {
    /** initialize your data structure here. */
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public exam30() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()){
            stack2.push(x);
        }
    }

    public void pop() {
        if (!stack1.isEmpty()){
            /*int tmp = stack1.pop();
            if (!stack2.isEmpty() && stack2.peek() == tmp){
                stack2.pop();
            }*/
            if (stack1.pop().equals(stack2.peek())){
                stack2.pop();
            }
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
