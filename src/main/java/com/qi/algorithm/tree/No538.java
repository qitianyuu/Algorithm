package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;

/**
 * Description: Convert BST to Greater Tree 把二叉搜索树转换为累加树
 *
 * 思路：累加树本质上就是反向累加每一个元素，数组表示 [1,2,3] -> [6,5,3]
 *      因此，反向中序遍历，并且每次加上前面的所有值。sum 是全局变量。
 *
 * Author: Qi
 * Date: 10-23-2021
 */
public class No538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

    public static void main(String[] args) {
        No538 no538 = new No538();
        TreeNode t = Tool.initTreeNode("3,2,4,1");
        TreeNode treeNode = no538.convertBST(t);
        Tool.printTree(treeNode);
    }
}
