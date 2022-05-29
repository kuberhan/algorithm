package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.Stack;

public class exam20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.isEmpty() || c != stack.peek()) return false;
            /*else if(!stack.isEmpty() && c == stack.peek()) stack.pop();*/
            else stack.pop();
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        String s = "(([]){})";
        System.out.println(isValid(s));
    }
}
