package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Subtree of Another Tree 另一棵树的子树
 * Author: Qi
 * Date: 09-01-2021
 */
public class No572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSame(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.left,subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)return true;
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
    }

    public static void main(String[] args) {
        No572 no572 = new No572();
        TreeNode t = initTreeNode("1,1");
        TreeNode t1 = initTreeNode("1");
        printTree(t);
        printTree(t1);
        boolean b = no572.isSubtree(t,t1);
        System.out.println(b);

    }
}
