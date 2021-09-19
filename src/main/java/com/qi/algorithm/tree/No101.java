package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Symmetric Tree 对称二叉树
 *
 * 思路：明确每个节点该干啥 对称节点：值是否相同？左子树右子树是否对称？
 *
 * Author: Qi
 * Date: 08-28-2021
 */
public class No101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return isSymmetric1(root.left, root.right);
    }

    private boolean isSymmetric1(TreeNode left, TreeNode right) {
        if (left == null)return right == null;
        if (right == null)return left == null;
        if (left.val != right.val) return false;
        return isSymmetric1(left.left, right.right) && isSymmetric1(left.right, right.left);
    }

    public static void main(String[] args) {
        No101 no101 = new No101();
        TreeNode t = initTreeNode("1,2,2,3,4,4,3");

        boolean b = no101.isSymmetric(t);
        System.out.println(b);
    }
}
