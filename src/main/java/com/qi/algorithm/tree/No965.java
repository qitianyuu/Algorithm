package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Univalued Binary Tree 单值二叉树
 * Author: Qi
 * Date: 09-02-2021
 */
public class No965 {

    Integer a = null;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (a == null){
            a = root.val;
        } else {
            if (root.val != a){
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        No965 no965 = new No965();
        TreeNode t = initTreeNode("1,1,2,1,1,#,1");
        boolean b = no965.isUnivalTree(t);
        System.out.println(b);
    }
}
