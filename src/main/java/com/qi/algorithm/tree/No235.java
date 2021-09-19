package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Lowest Common Ancestor of a Binary Search Tree 二叉搜索树的最近公共祖先
 *
 * 思路：注意是二叉搜索树，所以直接对比值大小，都大都小则继续递归，出现一大一小则为分岔点
 *
 * Author: Qi
 * Date: 08-31-2021
 */
public class No235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p,q);
        else if (root.val > p.val && root.val > q.val)return lowestCommonAncestor(root.left, p,q);
        else return root;
    }

    public static void main(String[] args) {
        No235 no235 = new No235();
        TreeNode t = initTreeNode("6,2,8,0,4,7,9,#,#,3,5");
        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(3);
        t = no235.lowestCommonAncestor(t,p,q);
        System.out.println(t.val);
    }
}
