package com.kuber.leetcode.swordtooffer;

import java.util.HashMap;

/*剑指 Offer 07. 重建二叉树*/
/*105. 从前序与中序遍历序列构造二叉树*/
/*根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right ；*/
public class exam07 {
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    /*分治法*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return divide(0,0,inorder.length - 1);
    }

    public TreeNode divide( int root, int left, int right){
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]);
        node.left = divide(root + 1, left, i - 1);
        node.right = divide(root + (i - left) + 1, i + 1, right);//这里不能偷懒root输入i+1，要考虑没有右子树的情况！
        return node;
    }

    /*=================================================================================================*/

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return divide2(preorder, 0, 0, inorder.length - 1, map);
    }

    public TreeNode divide2(int[] preorder, int root, int left, int right, HashMap<Integer, Integer> map){
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        Integer i = map.get(preorder[root]);
        node.left = divide2(preorder, root + 1, left, i - 1, map);
        node.right = divide2(preorder, root + (i - left) + 1, i + 1, right, map);
        return node;
    }
}
