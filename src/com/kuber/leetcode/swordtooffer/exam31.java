package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

import java.util.Stack;


/*946. 验证栈序列*/
/*剑指 Offer 31. 栈的压入、弹出序列*/
public class exam31 {

    /**
     * 考虑借用一个辅助栈 stack ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。
     * 入栈操作： 按照压栈序列的顺序执行。
     * 出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pushNum : pushed) {
            stack.push(pushNum);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        //也可以判断i是否等于数组长度
        //return i == popped.length;
        return stack.isEmpty();
    }

    @Test
    public void test(){
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,1,2};
        System.out.println(validateStackSequences(push, pop));
    }
}
