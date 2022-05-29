package com.kuber.leetcode.all;


import org.junit.Test;

import java.util.Stack;

/*946. 验证栈序列*/
/*剑指 Offer 31. 栈的压入、弹出序列*/
public class exam946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        int[] n1 = {1,2,3,4,5};
        int[] n2 = {4,5,3,2,1};
        System.out.println(validateStackSequences(n1, n2));
    }
}
