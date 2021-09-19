package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.HashSet;
import java.util.Set;

import static com.qi.algorithm.util.Tool.initTreeNode;

/**
 * Description:  Two Sum IV - Input is a BST 两数之和 IV - 输入 BST
 * Author: Qi
 * Date: 09-03-2021
 */
public class No653 {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null)return false;
        if (set.contains(k-root.val)){
            return true;
        }else {
            set.add(root.val);
            return find(root.right, k, set) || find(root.left, k, set);
        }
    }

    public static void main(String[] args) {
        No653 no653 = new No653();
        TreeNode t = initTreeNode("5,3,6,2,4,#,7");
        boolean b = no653.findTarget(t, 17);
        System.out.println(b);
    }
}
