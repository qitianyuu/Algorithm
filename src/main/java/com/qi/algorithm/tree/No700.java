package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Search in a Binary Search Tree 二叉搜索树中的搜索
 * Author: Qi
 * Date: 09-01-2021
 */
public class No700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)return null;
        if (root.val == val)return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        No700 no700 = new No700();
        TreeNode t = initTreeNode("4,2,7,1,3");
        printTree(t);
        t = no700.searchBST(t,5);
        if (t == null) {
            System.out.println("null");
        } else {
            printTree(t);
        }

    }
}
