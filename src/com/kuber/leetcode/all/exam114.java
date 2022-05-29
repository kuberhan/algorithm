package com.kuber.leetcode.all;


import com.kuber.leetcode.all.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*114. 二叉树展开为链表*/
public class exam114 {

    /*方法一（最容易想的）：先序遍历，加入到集合中，再遍历破坏结构，构成新树*/
    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root != null && !(root.left == null && root.right == null)) {
            dfs(root, res);
            root = res.get(0);
            TreeNode head = root;
            for (int i = 0; i < res.size(); i++) {
                root.left = null;
                root.right = res.get(i);
                root = root.right;
            }
            root = head;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> res) {
        if (root == null) return;
        res.add(root);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    /*方法二：非递归解法*/

    /**
     * 步骤：
     *      1.对每一个root节点，首先找到root节点的左子树最右边的节点，标记为mark
     *      2.再将root的右子树挂在mark的右节点上
     *      3.将root右子树指向左子树，将root右子树置空
     *      4.root指向root右子树
     *      5.重复上述步骤，直到root为空
     * @param root
     * @author kuber
     */
    public void flatten2(TreeNode root) {
        TreeNode head = root;
        while(root != null){
            if(root.left == null)   root = root.right;
            else {
                //找出左子树的最右边的节点
                TreeNode mark = root.left;
                while (mark.right != null){
                    mark = mark.right;
                }
                mark.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
        root = head;
    }
}
