package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: Path Sum III 路径总和 III
 *
 * 思路：前缀和，依次保存前 k 个数的和，由于是连续的，因此可以采用 ki - kj 得到 j~i 的字串的和
 *      类似 No.560
 *
 * Author: Qi
 * Date: 10-24-2021
 */
public class No437 {

    int ans;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        ans = 0;
        map.put(0l,1);
        dfs(root, map, 0l, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, Map<Long, Integer> map, Long p, int tar) {
        if (root == null) return;
        p += root.val;
        if (map.getOrDefault((p - tar), 0) >= 0){
            ans = ans + map.getOrDefault((p - tar), 0);
        }
        map.put(p, map.getOrDefault(p, 0)+1);
        dfs(root.left, map, p, tar);
        dfs(root.right, map, p, tar);
        map.put(p, map.getOrDefault(p, 0)-1);
    }

    public static void main(String[] args) {
        No437 no437 = new No437();
        TreeNode t = Tool.initTreeNode("0,1,1");
        System.out.println(no437.pathSum(t, 1));
    }
}
