package com.qi.algorithm.entity;

import lombok.Data;

/**
 * Description:
 * Author: Qi
 * Date: 06-04-2021
 */

@Data
public class ListNode {
    public ListNode next;
    public int val;
    public ListNode() {}
    public ListNode(int x){this.val = x;}
    public ListNode(int x, ListNode next){this.val = x; this.next = next;}
}


