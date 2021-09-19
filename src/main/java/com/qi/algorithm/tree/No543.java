package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Diameter of Binary Tree 二叉树的直径
 * Author: Qi
 * Date: 08-31-2021
 */
public class No543 {

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }


    public static void main(String[] args) {
        No543 no543 = new No543();
        TreeNode t = initTreeNode("1,2,3,4,5,6,7,8");
        printTree(t);
        int ans = no543.diameterOfBinaryTree(t);
        System.out.println(ans);
    }
}
