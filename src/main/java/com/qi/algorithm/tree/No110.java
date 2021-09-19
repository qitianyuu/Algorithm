package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Balanced Binary Tree 平衡二叉树
 * Author: Qi
 * Date: 09-03-2021
 */
public class No110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        return depth(root) >= 0;
    }

    private int depth(TreeNode root) {
        if (root == null)return 0;

        int l = depth(root.left);
        int r = depth(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1){
            return -1;
        }else {
            return Math.max(l, r) + 1;
        }
    }

    public static void main(String[] args) {
        No110 no110 = new No110();
        TreeNode t = initTreeNode("1,2,2,3,3,#,#,4,4");
        boolean b = no110.isBalanced(t);
        System.out.println(b);
    }
}
