package com.qi.algorithm.stringPro;

import java.util.List;

/**
 * Description: Maximum Depth of N-ary Tree N 叉树的最大深度
 *
 * 思路：递归深度优先遍历。
 *
 * Author: Qi
 * Date: 11-21-2021
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class No559 {

    int ans;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        ans = 0;
        dfs(root, 0);
        return ans + 1;
    }

    public void dfs(Node root, int depth){
        if (root.children.size() == 0 || root == null){
            ans = Math.max(ans, depth);
            return;
        }
        List<Node> list = root.children;

        for (int i = 0; i < list.size(); i++){
            dfs(list.get(i), depth + 1);
        }
    }
}
