package com.kuber.leetcode.all;

import java.util.Stack;

/*155. 最小栈*/
public class exam155 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public exam155() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty() || val < stack2.peek()){
            stack2.push(val);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
