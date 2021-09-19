package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Second Minimum Node In a Binary Tree 二叉树中第二小的节点
 *
 * 思路：准确理解返回值的含义，本题找到第二小的值，则从跟节点向下递归
 *      针对每个节点，先取到其左右子节点，如果与跟节点值相同，则继续递归，如不同，则为此棵子树的最小值
 *      如此往复，得到第二小节点。
 *
 * Author: Qi
 * Date: 09-01-2021
 */
public class No671 {


    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null)return -1;

        int lmin = root.left.val;
        int rmin = root.right.val;
        if (lmin == root.val){
            lmin = findSecondMinimumValue(root.left);
        }
        if (rmin == root.val){
            rmin = findSecondMinimumValue(root.right);
        }

        if (lmin == -1){
            return rmin;
        }
        if (rmin == -1){
            return lmin;
        }

        return Math.min(lmin, rmin);

    }

    public static void main(String[] args) {
        No671 no671 = new No671();
        TreeNode t = initTreeNode("2,2,5,#,#,5,7");
        int ans = no671.findSecondMinimumValue(t);
        System.out.println(ans);
    }
}
