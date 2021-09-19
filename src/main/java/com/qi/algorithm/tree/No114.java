package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: Flatten Binary Tree to Linked List 二叉树展开为链表
 *
 * 思路：明确每个节点该干啥，
 *      就根节点而言，先反转左子树，然后翻转右子树，
 *      然后将左子树设置为右子树，将左子树置空
 *      然后拼接右子树在左子树末尾即可。
 *
 * Author: Qi
 * Date: 08-27-2021
 */
public class No114 {

    //递归解法
    public void flatten(TreeNode root) {
        if (root == null)return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = null;
        while (root.right != null){
            root = root.right;
        }
        root.right = right;

    }

    // 前序遍历得到二叉树的访问顺序
    public void flatten1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i-1), cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    public static void main(String[] args) {

    }
}
