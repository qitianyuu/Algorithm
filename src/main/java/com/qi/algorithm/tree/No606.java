package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description: Construct String from Binary Tree 根据二叉树创建字符串
 * Author: Qi
 * Date: 09-03-2021
 */
public class No606 {

    public String tree2str(TreeNode root) {
        if (root == null)return null;
        String l = tree2str(root.left);
        String r = tree2str(root.right);
        if (l == null){
            if (r == null){
                return String.valueOf(root.val);
            } else{
                StringBuffer sb = new StringBuffer();
                sb.append(root.val).append("()(").append(r).append(")");
                return sb.toString();
            }
        }else {
            if (r == null){
                StringBuffer sb = new StringBuffer();
                sb.append(root.val).append("(").append(l).append(")");
                return sb.toString();
            }else {
                StringBuffer sb = new StringBuffer();
                sb.append(root.val).append("(").append(l).append(")(").append(r).append(")");
                return sb.toString();
            }
        }
    }

    public static void main(String[] args) {
        No606 no606 = new No606();
        TreeNode t = initTreeNode("1,2,3,#,4");
        String s = no606.tree2str(t);
        System.out.println(s);
    }
}
