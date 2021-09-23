package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import com.qi.algorithm.util.Tool;
import java.util.*;

/**
 * Description: Find Largest Value in Each Tree Row 在每个树行中找最大值
 *
 * 思路：本题可以通过 深度优先算法 和 层序遍历 解决。
 *
 * Author: Qi
 * Date: 09-22-2021
 */
public class No515 {

    // dfs 算法
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        trackback(root, map, 0);
        for (int i = 0; i < map.keySet().size(); i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private void trackback(TreeNode root, Map<Integer, Integer> map, int depth) {
        if (root == null)return;
        int a = map.getOrDefault(depth, root.val);
        map.put(depth, Math.max(root.val, a));
        if (root.right == null && root.left == null){
            return;
        }else {
            trackback(root.left, map, depth+1);
            trackback(root.right, map, depth+1);
        }
    }

    // 层序遍历 算法
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                max = Math.max(tmp.val, max);
                if (tmp.left != null)q.offer(tmp.left);
                if (tmp.right != null)q.offer(tmp.right);
            }
            list.add(max);
        }
        return list;
    }

    public static void main(String[] args) {
        No515 no515 = new No515();
        TreeNode t = Tool.initTreeNode("1,3,2,5,3,#,9");
        Tool.printTree(t);
        List<Integer> integers = no515.largestValues1(t);
        System.out.println(integers.toString());
    }
}
