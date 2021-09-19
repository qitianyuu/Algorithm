package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Merge Two Binary Trees 合并二叉树
 *
 * 思路：看官方正解，理解返回的含义,自己写的是一个反例，不用额外定义方法，合理利用返回值
 *
 * Author: Qi
 * Date: 09-01-2021
 */
public class No617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)return root1;
        if (root1 != null && root2 != null){
            root1.val += root2.val;
        }
        mergeTrees1(root1,root2);
        return root1;
    }

    private void mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1.left != null && root2.left != null){
            root1.left.val += root2.left.val;
            mergeTrees1(root1.left,root2.left);
        }else {
            if (root2.left != null){
                root1.left = root2.left;
            }
        }

        if (root1.right != null && root2.right != null){
            root1.right.val += root2.right.val;
            mergeTrees1(root1.right,root2.right);
        }else {
            if (root2.right != null){
                root1.right = root2.right;
            }
        }
    }

    //官方正解
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null)return root2;
        if (root2 == null)return root1;
        root1.val += root2.val;
        root1.left = mergeTrees2(root1.left, root2.left);
        root1.right = mergeTrees2(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        No617 no617 = new No617();
        TreeNode t1 = initTreeNode("1,2,3");
        TreeNode t2 = initTreeNode("1,2");
        t1 = no617.mergeTrees2(t1,t2);
        printTree(t1);

    }
}
