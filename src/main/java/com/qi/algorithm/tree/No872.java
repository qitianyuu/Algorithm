package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Leaf-Similar Trees 叶子相似的树
 *
 * 思路：通过遍历两棵树找到叶子节点到序列，最后判断两个是否相等。
 *
 * Author: Qi
 * Date: 09-01-2021
 */
public class No872 {

    StringBuffer sb = new StringBuffer();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeaf(root1);
        getLeaf(root2);
        if (sb.length() % 2 != 0)return false;
        else {
            int mid = sb.length() / 2;
            return sb.substring(0,mid).equals(sb.substring(mid,sb.length()));
        }
    }

    private void getLeaf(TreeNode root) {
        if (root == null)return;
        if (root.left == null && root.right == null){
            sb.append("-");
            sb.append(root.val);
            sb.append("-");
            return;
        }
        getLeaf(root.left);
        getLeaf(root.right);
    }

    public static void main(String[] args) {
        No872 no872 = new No872();
        TreeNode t1 = initTreeNode("3,5,1,6,2,9,8,#,#,7,4");
        TreeNode t2 = initTreeNode("3,5,1,6,7,4,2,#,#,#,#,#,#,9,8");
        printTree(t1);
        printTree(t2);
        boolean b = no872.leafSimilar(t1, t2);
        System.out.println(b);
    }
}
