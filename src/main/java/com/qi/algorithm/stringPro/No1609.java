package com.qi.algorithm.stringPro;

import com.qi.algorithm.entity.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: Even Odd Tree 奇偶树
 *
 * 思路：队列实现，一层一层的取，按照层的深度确定本层的规则。
 *
 * Author: Qi
 * Date: 12-25-2021
 */
public class No1609 {

    public boolean isEvenOddTree(TreeNode root) {
        int layer = 0, nodeNum;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            nodeNum = q.size();
            int[]tmps = new int[nodeNum];
            for (int i = 0; i < nodeNum; i++) {
                TreeNode tmp = q.pollFirst();
                if (tmp.left != null)q.offer(tmp.left);
                if (tmp.right != null)q.offer(tmp.right);
                tmps[i] = tmp.val;
            }
            if (!check(tmps, layer)){
                return false;
            }
            layer++;
        }
        return true;
    }

    private boolean check(int[] tmps, int layer) {
        if (layer % 2 == 0){
            for (int i = 0; i < tmps.length - 1; i++) {
                if (tmps[i] % 2 == 0 || tmps[i] >= tmps[i + 1]){
                    return false;
                }
            }
            return tmps[tmps.length - 1] % 2 != 0;
        }else {
            for (int i = 0; i < tmps.length - 1; i++) {
                if (tmps[i] % 2 != 0 || tmps[i] <= tmps[i + 1]) {
                    return false;
                }
            }
            return tmps[tmps.length - 1] % 2 == 0;
        }
    }

    public static void main(String[] args) {

    }
}
