package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: House Robber III 打家劫舍 III
 *
 * 思路：动态规划，主要是想明白，本节点的状态由谁决定
 *      首先，本节点有两种状态，选还是不选
 *      1.选 则本节点的值就是当前节点 val + 两个节点都不选的值
 *      2.不选 则本节点的值是两个字节点的值相加，两个字节点的值又是由 Math.max(选子节点，不选子节点) 得到的。
 *
 * Author: Qi
 * Date: 10-18-2021
 */
public class No337 {

    Map<TreeNode, Integer> choose = new HashMap<>();
    Map<TreeNode, Integer> noChoose = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(choose.getOrDefault(root, 0), noChoose.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null)return;
        dfs(root.left);
        dfs(root.right);
        choose.put(root, root.val + noChoose.getOrDefault(root.left, 0) + noChoose.getOrDefault(root.right, 0));
        noChoose.put(root, Math.max(choose.getOrDefault(root.left, 0), noChoose.getOrDefault(root.left, 0)) + Math.max(choose.getOrDefault(root.right, 0), noChoose.getOrDefault(root.right, 0)));
    }


    public static void main(String[] args) {
        No337 no337 = new No337();
        TreeNode t = Tool.initTreeNode("3,2,3,#,3,#,1");
        System.out.println(no337.rob(t));
    }
}
