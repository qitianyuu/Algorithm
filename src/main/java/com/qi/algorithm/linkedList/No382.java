package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:
 *
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * Author: Qi
 * Date: 07-16-2021
 */
public class No382 {

    Random random = new Random();
    List<Integer> list = new ArrayList<>();

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public No382(ListNode head) {
        if (head == null){
            return;
        }
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }

}
