package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Binary Tree Tilt 二叉树的坡度
 * Author: Qi
 * Date: 09-01-2021
 */
public class No563 {

    int ans = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return ans;
    }

    private int sum(TreeNode root) {
        if (root == null)return 0;
        int l = sum(root.left);
        int r = sum(root.right);
        ans += Math.abs(l - r);
        return root.val + l + r;
    }

    public static void main(String[] args) {
        No563 no563 = new No563();
        TreeNode t = initTreeNode("21,7,14,1,1,2,2,3,3");
        int ans = no563.findTilt(t);
        System.out.println(ans);
    }
}
