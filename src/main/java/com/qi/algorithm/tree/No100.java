package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Same Tree 相同的树
 *
 * 思路：明确每个节点该干啥，对比值是否相同，左节点是否相同，右节点是否相同
 *
 * Author: Qi
 * Date: 08-28-2021
 */
public class No100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null)return q == null;
        if (q == null)return p == null;
        if (p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        No100 no100 = new No100();
        TreeNode t1 = initTreeNode("1,2,3");
        TreeNode t2 = initTreeNode("1,2,3,4");
        boolean b = no100.isSameTree(t1,t2);
        System.out.println(b);
    }
}
