package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 * Author: Qi
 * Date: 07-14-2021
 */
public class No160 {

    //哈希表的方法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        if (l1 == null || l2 == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (l1 != null){
            set.add(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            boolean b = set.add(l2);
            if (b == false){
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }

    // 双指针方法 两个指针分别从两个链表头开始遍历，到尾后转到另一个链表的头开始遍历，这样如果有交点一定会碰上，
    // 没有交点的话 二者最后会都为空
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode a, b;
        a = headA;
        b = headB;
        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


    public static void main(String[] args) {
        No160 no160 = new No160();
        ListNode l1 = Tool.initLinkList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode l2 = Tool.initLinkList(new int[]{9, 8});
        l2.next.next = l1.next.next.next;
        Tool.printLinkList(no160.getIntersectionNode1(l1, l2));

    }
}
