package com.qi.algorithm.tree;

import com.qi.algorithm.entity.TreeNode;

import static com.qi.algorithm.util.Tool.initTreeNode;
import static com.qi.algorithm.util.Tool.printTree;

/**
 * Description: Sum of Left Leaves 左叶子之和
 *
 * 思路：考虑每个节点该干啥，对于本题来说，应该先判断是否为左叶子节点，
 *      是的话就加上值并返回，不是的话就直接返回或者继续递归。
 *
 * Author: Qi
 * Date: 08-31-2021
 */
public class No404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)return 0;
        int ans = 0;
        ans = sumOfLeftLeaves1(root.left, 0, ans);
        ans = sumOfLeftLeaves1(root.right, 1, ans);
        return ans;
    }

    private int sumOfLeftLeaves1(TreeNode root, int flag, int ans) {
        if (root == null){
            return ans;
        }
        if (root.left == null && root.right == null){
            if (flag == 0){
                ans += root.val;
                return ans;
            }else {
                return ans;
            }
        }else {
            ans = sumOfLeftLeaves1(root.left, 0, ans);
            ans = sumOfLeftLeaves1(root.right, 1, ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        No404 no404 = new No404();
        TreeNode t = initTreeNode("1,2,3,4,5,6,#,8,#,9");
        printTree(t);
        int ans = no404.sumOfLeftLeaves(t);
        System.out.println(ans);
    }
}
