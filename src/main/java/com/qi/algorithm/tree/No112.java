package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Path Sum 路径总和
 *
 * 思路：想明白每个节点该干啥，每个节点就是看自己是否是烨子节点，如果是，则判断减掉路径是否为零，
 *      如果不是叶子节点，则向左向右递归，同时间去自己的val。
 *
 * Author: Qi
 * Date: 08-29-2021
 */
public class No112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        else if (root.left == null && root.right == null)return false;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        No112 no112 = new No112();
        TreeNode t = initTreeNode("-2,#,-3");
        boolean b = no112.hasPathSum(t,-5);
        System.out.println(b);
    }
}
