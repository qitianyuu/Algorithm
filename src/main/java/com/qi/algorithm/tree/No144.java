package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Binary Tree Preorder Traversal 二叉树的前序遍历
 * Author: Qi
 * Date: 08-29-2021
 */
public class No144 {

    // 递归的方法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preorderTraversal1(root, list);
    }

    private List<Integer> preorderTraversal1(TreeNode root, List<Integer> list) {
        if (root == null)return list;
        list.add(root.val);
        preorderTraversal1(root.left, list);
        preorderTraversal1(root.right, list);
        return list;
    }

    //利用栈
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }


    public static void main(String[] args) {
        No144 no144 = new No144();
        TreeNode t = initTreeNode("1,2,3,4,5,6,7");
        printTree(t);
        List<Integer> ans = no144.preorderTraversal2(t);
        ans.forEach(item -> {
            System.out.println(item);
        });
    }
}
