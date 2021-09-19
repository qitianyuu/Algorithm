package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Minimum Absolute Difference in BST 二叉搜索树的最小绝对差
 *
 * 思路：中序遍历，然后分别计算每两个中间的差值取最小。
 *
 * Author: Qi
 * Date: 08-31-2021
 */
public class No530 {

    int ans,pre;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null)return;
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }



    public static void main(String[] args) {
        No530 no530 = new No530();
        TreeNode t = initTreeNode("17,7,20,3,14");
        int ans = no530.getMinimumDifference(t);
        System.out.println(ans);
    }
}
