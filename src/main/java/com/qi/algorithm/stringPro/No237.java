package com.qi.algorithm.stringPro;

import com.qi.algorithm.entity.ListNode;

/**
 * Description: Delete Node in a Linked List 删除链表中的节点
 *
 * 思路：由当前节点向后遍历替换值
 *
 * Author: Qi
 * Date: 11-02-2021
 */
public class No237 {

    public void deleteNode(ListNode node) {
        if (node == null)return;
        ListNode c, p;
        c = node;
        p = c.next;
        while (p != null && p.next != null){
            c.val = p.val;
            c = c.next;
            p = p.next;
        }
        c.val = p.val;
        c.next = null;
        return;
    }

    public static void main(String[] args) {

    }
}
