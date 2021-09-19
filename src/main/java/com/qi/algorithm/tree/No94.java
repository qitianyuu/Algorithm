package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: 94. Binary Tree Inorder Traversal 二叉树的中序遍历
 * Author: Qi
 * Date: 08-28-2021
 */
public class No94 {

    //递归实现中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null)return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    //迭代实现中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public static void main(String[] args) {
        No94 no94 = new No94();
        TreeNode t = initTreeNode("1,2,3,4,#,6,7");
        printTree(t);
        List<Integer> integers = no94.inorderTraversal1(t);
        integers.forEach(integer -> {
            System.out.println(integer);
        });
    }

}
