package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Range Sum of BST 二叉搜索树的范围和
 * Author: Qi
 * Date: 09-02-2021
 */
public class No938 {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return sum;
        if (root.val <= high && root.val >= low)sum += root.val;
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return sum;
    }

    public static void main(String[] args) {
        No938 no938 = new No938();
        TreeNode t = initTreeNode("10,5,15,3,7,13,18,1,#,6");
        int ans = no938.rangeSumBST(t, 6, 10);
        System.out.println(ans);
    }
}
