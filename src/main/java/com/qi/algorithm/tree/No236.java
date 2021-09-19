package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Lowest Common Ancestor of a Binary Tree 二叉树的最近公共祖先
 *
 * 思路：先判断此节点是否为目标节点，如果是则返回此节点，不是的话向左右分别递归
 *      然后递归结束判断是否左右都有符合条件的点，如果有的话则此节点为分岔节点，没有的话就单独判断是在哪课子树上，进行递归。
 *
 * Author: Qi
 * Date: 08-31-2021
 */
public class No236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode ltree = lowestCommonAncestor(root.left, p, q);
        TreeNode rtree = lowestCommonAncestor(root.right, p, q);
        if (ltree != null && rtree != null)return root;
        if (ltree == null) return rtree;
        if (rtree == null) return ltree;
        return null;
    }

    public static void main(String[] args) {
        No236 no236 = new No236();
        TreeNode t = initTreeNode("1,2,3,#,4");
        printTree(t);
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(4);
        t = no236.lowestCommonAncestor(t,p,q);
        System.out.println(t.val);
    }
}
