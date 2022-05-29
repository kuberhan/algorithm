package com.kuber.leetcode.swordtooffer;


import java.util.*;


/*剑指 Offer 32 - III. 从上到下打印二叉树 III*/
public class exam32_3 {

    /*层次遍历+双栈*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();
        boolean levelFlag = false; //false为奇数层
        while (!stack1.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentSize = stack1.size();
            //确保每次只处理一层的节点
            for (int i = 0; i < currentSize; i++) {
                TreeNode pop = stack1.pop();
                if (!levelFlag){
                    if (pop.left != null) stack2.push(pop.left);
                    if (pop.right != null) stack2.push(pop.right);
                }else {
                    if (pop.right != null) stack2.push(pop.right);
                    if (pop.left != null) stack2.push(pop.left);
                }

                level.add(pop.val);
            }
            //两个栈进行交换，把这一次循环的第二个结果栈作为下一次循环的开始栈
            Stack<TreeNode> tem = stack2;
            stack2 = stack1;
            stack1 = tem;
            levelFlag = !levelFlag;
            res.add(level);
        }
        return res;
    }

    /*层次遍历+双端队列*/
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean levelFlag = false; //false为奇数层
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //确保每次只处理一层的节点
            int currentSize = deque.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode leaveNode;
                if (!levelFlag){//奇数层
                    leaveNode = deque.removeFirst();
                    level.add(leaveNode.val);
                    if (leaveNode.left != null) deque.addLast(leaveNode.left);
                    if (leaveNode.right != null) deque.addLast(leaveNode.right);
                }else {
                    leaveNode = deque.removeLast();
                    level.add(leaveNode.val);
                    if (leaveNode.right != null) deque.addFirst(leaveNode.right);
                    if (leaveNode.left != null) deque.addFirst(leaveNode.left);
                }
            }
            res.add(level);
            levelFlag = ! levelFlag;
        }
        return res;
    }

    /*层次遍历+双端队列+奇偶层逻辑分离*/
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        //boolean levelFlag = false; //false为奇数层
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //确保每次只处理一层的节点
            for (int i = deque.size(); i > 0; i--) {
                TreeNode leaveNode = deque.removeFirst();
                level.add(leaveNode.val);
                if (leaveNode.left != null) deque.addLast(leaveNode.left);
                if (leaveNode.right != null) deque.addLast(leaveNode.right);

            }
            res.add(level);
            if (deque.isEmpty()) break;
            level = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode leaveNode = deque.removeLast();
                level.add(leaveNode.val);
                if (leaveNode.right != null) deque.addFirst(leaveNode.right);
                if (leaveNode.left != null) deque.addFirst(leaveNode.left);
            }

            res.add(level);
        }
        return res;
    }
}
