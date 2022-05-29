package com.kuber.leetcode.all;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*二叉树的层序遍历*/
/*思路：
    二叉树头节点先入队列，该节点的有左子树，则左子树根节点入队列，如果该节点有右子树，则将右子树根节点入队列；
    随后将队列的第一个节点出队，添加到list数组当中，出队的次数和当前层数节点数有关，内层for循环就是做这个的
*/
public class exam102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) return result;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int currentLevelSize = deque.size();//因为队列size一直在变化，所以下面不能用i<size，而且每一次while就是一层的节点数
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = deque.getFirst();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                list.add(deque.poll().val);
            }
            result.add(list);
        }
        return result;
    }
}
