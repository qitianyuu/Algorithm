package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: 104. Maximum Depth of Binary Tree 二叉树的最大深度
 * Author: Qi
 * Date: 08-28-2021
 */
public class No104 {

    public int maxDepth(TreeNode root) {
        if (root == null)return 0;
        return 1 + Math.max(maxDepth(root.right),maxDepth(root.left));
    }

    public static void main(String[] args) {
        No104 no104 = new No104();
        TreeNode t = initTreeNode("1,2,3,4,5,6,7,#,#,#,1");
        int ans = no104.maxDepth(t);
        System.out.println(ans);
    }
}
