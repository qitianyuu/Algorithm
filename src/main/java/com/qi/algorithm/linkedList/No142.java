package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * Author: Qi
 * Date: 07-15-2021
 */
public class No142 {

    //哈希表的方法
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode c = head;
        while (c != null){
            if (set.contains(c)){
                c.next = null;
                return c;
            }else {
                set.add(c);
            }
            c = c.next;
        }
        return null;
    }

    //快慢指针方法
    public ListNode detectCycle1(ListNode head){
        if (head == null ||head.next == null){
            return null;
        }
        ListNode fast, slow;
        //快慢指针同一起点，可保证追上的时候恰巧在第一圈
        fast = slow = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            //追上了，则在此时从头开始往后便利，同时让slow往后遍历，则相遇点即是环状点
            if (fast == slow){
                ListNode c = head;
                while (c != slow){
                    c = c.next;
                    slow = slow.next;
                }
                return c;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        //[-21,10,17,8,4 ,26,5,35,33,-7  ,-16,27,-12,6,29,  -12,5,9,20,14, 14,2,13,-24,21, 23,-21,5]
        //24
        No142 no142 = new No142();
        ListNode l1 = new ListNode(-21);
        ListNode l2 = new ListNode(10);
        ListNode l3 = new ListNode(17);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(4);

        ListNode l6 = new ListNode(26);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(35);
        ListNode l9 = new ListNode(33);
        ListNode l10 = new ListNode(-7);

        ListNode l11 = new ListNode(-16);
        ListNode l12 = new ListNode(27);
        ListNode l13 = new ListNode(-12);
        ListNode l14 = new ListNode(6);
        ListNode l15 = new ListNode(29);

        ListNode l16 = new ListNode(-12);
        ListNode l17 = new ListNode(5);
        ListNode l18 = new ListNode(9);
        ListNode l19 = new ListNode(20);
        ListNode l20 = new ListNode(14);

        ListNode l21 = new ListNode(14);
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(13);
        ListNode l24 = new ListNode(-24);
        ListNode l25 = new ListNode(21);

        ListNode l26 = new ListNode(23);
        ListNode l27 = new ListNode(-21);
        ListNode l28 = new ListNode(5);

        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        l5.setNext(l6);

        l6.setNext(l7);
        l7.setNext(l8);
        l8.setNext(l9);
        l9.setNext(l10);
        l10.setNext(l11);

        l11.setNext(l12);
        l12.setNext(l13);
        l13.setNext(l14);
        l14.setNext(l15);
        l15.setNext(l16);

        l16.setNext(l17);
        l17.setNext(l18);
        l18.setNext(l19);
        l19.setNext(l20);
        l20.setNext(l21);

        l21.setNext(l22);
        l22.setNext(l23);
        l23.setNext(l24);
        l24.setNext(l25);
        l25.setNext(l26);

        l26.setNext(l27);
        l27.setNext(l28);
        l28.setNext(l24);

        l1 = no142.detectCycle1(l1);
        System.out.println(l1.val);
    }
}
