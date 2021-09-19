package com.qi.algorithm.tree;

import com.qi.algorithm.entity.Node;

/**
 * Description: Populating Next Right Pointers in Each Node 填充每个节点的下一个右侧节点指针
 *
 * 思路：二叉树的问题难点在于，如何把题目的要求细化成每个节点需要做的事情
 *      这个问题单独用一个节点不能解决，故用两个节点，
 *      先让其相连，然后让其左右相连，后让左节点的右子节点连接右节点的左子节点
 *
 *
 * Author: Qi
 * Date: 08-27-2021
 */
public class No116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    public void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        connectTwoNode(left.right, right.left);
    }


    public static void main(String[] args) {

    }
}
