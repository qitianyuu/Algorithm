package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Sum of Root To Leaf Binary Numbers 从根到叶的二进制数之和
 *
 * 思路：利用栈实现遍历，同时更改节点值，让上层数值传递下去，利用位运算
 *      入栈先右后左，弹栈则为从左至右
 *
 * Author: Qi
 * Date: 09-03-2021
 */
public class No1022 {

    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            int val = tmp.val;
            if (tmp.left == null && tmp.right == null){
                sum += val;
                continue;
            }

            if (tmp.right != null){
                tmp.right.val = (val << 1) | tmp.right.val;
                stack.push(tmp.right);
            }
            if (tmp.left != null){
                tmp.left.val = (val << 1) | tmp.left.val;
                stack.push(tmp.left);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        No1022 no1022 = new No1022();
        TreeNode t = initTreeNode("1,0,1,0,1,0,1");
        printTree(t);
        int ans = no1022.sumRootToLeaf(t);
        System.out.println(ans);
    }
}
