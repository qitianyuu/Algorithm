package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Average of Levels in Binary Tree 二叉树的层平均值
 *
 * 思路：用队列实现层序遍历，并分层处理，求出每层的平均值。
 *
 * Author: Qi
 * Date: 09-01-2021
 */
public class No637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                TreeNode l = tmp.left;
                TreeNode r = tmp.right;
                if (l != null) queue.offer(l);
                if (r != null) queue.offer(r);
            }
            ans.add(sum / size);
        }
        return ans;
    }

    public static void main(String[] args) {
        No637 no637 = new No637();
        TreeNode t = initTreeNode("1,2,3,4,5,6,7,8");
        List<Double> ans = no637.averageOfLevels(t);
        ans.forEach( item -> {
            System.out.println(item);
        });
    }
}
