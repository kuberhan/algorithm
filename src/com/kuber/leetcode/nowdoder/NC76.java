package com.kuber.leetcode.nowdoder;

import org.junit.Test;

import java.util.Stack;

public class NC76 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) return stack2.pop();
        return -1;
    }

    @Test
    public void test(){
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        push(5);
        System.out.println(pop());
        System.out.println(pop());
    }
}
