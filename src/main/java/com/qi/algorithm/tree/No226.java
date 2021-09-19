package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.*;

/**
 * Description: Invert Binary Tree 翻转二叉树
 * Author: Qi
 * Date: 08-26-2021
 */
public class No226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        No226 no226 = new No226();
        TreeNode t = initTreeNode("1,2,#,4,5,#,#");
        printTree(t);
        t = no226.invertTree(t);
        printTree(t);
    }
}
