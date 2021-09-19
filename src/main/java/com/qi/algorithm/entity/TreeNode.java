package com.qi.algorithm.entity;

import lombok.Data;

/**
 * Description:
 * Author: Qi
 * Date: 08-26-2021
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}
