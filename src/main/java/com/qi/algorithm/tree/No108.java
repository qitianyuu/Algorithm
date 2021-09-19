package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Convert Sorted Array to Binary Search Tree 将有序数组转换为二叉搜索树
 *
 * 重点，有序数组转二叉排序树
 *
 * Author: Qi
 * Date: 08-28-2021
 */
public class No108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sTot(nums, 0, nums.length - 1);
    }

    private TreeNode sTot(int[] nums, int left, int right) {
        if (left > right)return null;

        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sTot(nums, left, mid - 1);
        root.right = sTot(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        No108 no108 = new No108();
        TreeNode t = no108.sortedArrayToBST(new int[]{0,1,2,3,4,5});
        printTree(t);
    }
}
