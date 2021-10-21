package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;

/**
 * Description: 打家劫舍 III
 * Author: Qi
 * Date: 10-18-2021
 */
public class No337 {

    int max;
    public int rob(TreeNode root) {
        max = 0;
        if (root == null)return 0;
        dfs(root, true, root.val);
        dfs(root, false, 0);
        return max;
    }

    private void dfs(TreeNode root, boolean flag, int total) {
        if (root.left == null && root.right == null){
            max = Math.max(max, total);
            return;
        }
        if (flag){
            if (root.left != null){
                dfs(root.left, false, total);
            }
            if (root.right != null){
                dfs(root.right, false, total);
            }
        }else{
            if (root.left != null){
                dfs(root.left, true, total+root.left.val);
                dfs(root.left, false, total);
            }
            if (root.right != null){
                dfs(root.right, true, total+root.right.val);
                dfs(root.right, false, total);
            }
        }
    }

    public static void main(String[] args) {
        No337 no337 = new No337();
        TreeNode t = Tool.initTreeNode("3,2,3,#,3,#,1");
        System.out.println(no337.rob(t));
    }
}
