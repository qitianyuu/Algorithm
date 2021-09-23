package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;

/**
 * Description: Find Bottom Left Tree Value 找树左下角的值
 *
 * 思路：dfs 遍历，找出 depth 值最大的点的 val 即可。
 *
 * Author: Qi
 * Date: 09-19-2021
 */
public class No513 {

    int ans;
    int maxDep;
    public int findBottomLeftValue(TreeNode root) {
        maxDep = -1;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            if (maxDep < depth){
                maxDep = depth;
                ans = root.val;
            }
            return;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }

    public static void main(String[] args) {
        No513 no513 = new No513();
        TreeNode t = Tool.initTreeNode("1,2,3");
        Tool.printTree(t);
        int ans = no513.findBottomLeftValue(t);
        System.out.println(ans);
    }
}
