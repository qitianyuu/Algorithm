package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;

/**
 * Description:
 *
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * Author: Qi
 * Date: 07-14-2021
 */
public class No141 {

    //快慢指针问题，快指针追上慢的证明套圈了，有圈
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode low = head;
        ListNode fast = head.next;
        while (low != fast){
            if (low == null || fast == null){
                return false;
            }
            low = low.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        No141 no141 = new No141();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        //ListNode l3 = new ListNode(3);
        //ListNode l4 = new ListNode(4);
        //ListNode l5 = new ListNode(5);

        l1.setNext(l2);
        //l2.setNext(l3);
        //l3.setNext(l4);
        //l4.setNext(l5);
        //l5.setNext(l1);

        Boolean b = no141.hasCycle(l1);
        System.out.println(b);

    }
}
