package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Binary Tree Paths 二叉树的所有路径
 * Author: Qi
 * Date: 08-29-2021
 */
public class No257 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        if (root.right == null && root.left == null){
            list.add(sb.toString());
            return list;
        }
        StringBuffer tmp = new StringBuffer(sb);
        binaryTreePaths1(root.left, list, sb);
        binaryTreePaths1(root.right, list, tmp);
        return list;

    }



    private void binaryTreePaths1(TreeNode root, List<String> list, StringBuffer sb) {
        if (root == null)return;
        sb.append("->");
        sb.append(root.val);
        if (root.left == null && root.right == null){
            list.add(sb.toString());
            return;
        } else {
            StringBuffer tmp = new StringBuffer(sb);
            binaryTreePaths1(root.left, list, sb);
            binaryTreePaths1(root.right, list, tmp);
            return;
        }
    }

    public static void main(String[] args) {
        No257 no257 = new No257();
        TreeNode t = initTreeNode("1");
        List<String> list = no257.binaryTreePaths(t);
        list.forEach(item -> {
            System.out.println(item);
        });
    }
}
