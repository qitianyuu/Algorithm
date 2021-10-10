package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: Binary Tree Level Order Traversal 二叉树的层序遍历
 *
 * 思路：最经典的层序遍历，采用队列的方式进行存储每个节点，然后每次外循环记录当前队列内部的个数为当前层的个数
 *
 * Author: Qi
 * Date: 10-10-2021
 */
public class No102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = 0;
        while (!q.isEmpty()){
            size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.removeFirst();
                if (tmp.left != null)q.offer(tmp.left);
                if (tmp.right != null)q.offer(tmp.right);
                list.add(tmp.val);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        No102 no102 = new No102();
        TreeNode t = Tool.initTreeNode("1,2,3,4,5,6,7");
        List<List<Integer>> lists = no102.levelOrder(t);
        lists.forEach(item ->{
            item.forEach(i ->{
                System.out.println(i);
            });
        });
    }
}
