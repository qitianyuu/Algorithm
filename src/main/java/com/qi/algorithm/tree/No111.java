package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

/**
 * Description: Minimum Depth of Binary Tree 二叉树的最小深度
 *
 * 思路：明确每个节点该干啥，本题目要求叶子节点的最小深度，故需确定其节点为叶子节点
 *
 * Author: Qi
 * Date: 08-28-2021
 */
public class No111 {

    public int minDepth(TreeNode root) {
        if (root == null)return 0;
        else if (root.right == null) return 1 + minDepth(root.left);
        else if (root.left == null) return 1 + minDepth(root.right);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {

    }
}
