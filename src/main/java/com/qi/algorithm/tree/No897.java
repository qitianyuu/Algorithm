package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Increasing Order Search Tree 递增顺序搜索树
 *
 * 思路：可以用递归的方法实现中序遍历，也可以用栈实现中序遍历，同时在中序遍历中操作。
 *
 * Author: Qi
 * Date: 09-02-2021
 */
public class No897 {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode tmpRoot = new TreeNode();
        TreeNode p = null, node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node.left = null;
            if (p == null){
                tmpRoot.right = node;
                p = node;
            }
            else{
                p.right = node;
                p = p.right;
            }
            node = node.right;
        }
        return tmpRoot.right;
    }

    public static void main(String[] args) {
        No897 no897 = new No897();
        TreeNode t = initTreeNode("5,3,6,2,4,#,8,1,#,#,#,7,9");
        t = no897.increasingBST(t);
        printTree(t);
    }
}
