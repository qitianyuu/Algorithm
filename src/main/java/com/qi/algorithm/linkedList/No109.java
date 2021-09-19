package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;

/**
 * Description: Convert Sorted List to Binary Search Tree 有序链表转换二叉搜索树
 *
 * 思路：类似有序数组生成排序二叉树，先找到中间节点，然后取出来做根，然后递归左右子树为左半部分和右半部分
 *
 * Author: Qi
 * Date: 09-03-2021
 */
public class No109 {

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right)return null;
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode fast, slow;
        fast = slow = left;
        while (fast != right && fast.next != right){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        No109 no109 = new No109();
        ListNode l = Tool.initLinkList(new int[]{-10, -3, 0, 5, 9});
        TreeNode treeNode = no109.sortedListToBST(l);
        Tool.printTree(treeNode);
    }
}
