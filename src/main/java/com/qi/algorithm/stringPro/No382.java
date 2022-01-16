package com.qi.algorithm.stringPro;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description: Linked List Random Node 链表随机节点
 * Author: Qi
 * Date: 01-16-2022
 */
public class No382 {

    Random r;
    List<Integer> list;
    public No382(ListNode head) {
        r = new Random();
        list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        ListNode h = Tool.initLinkList(new int[]{1, 2, 3});
        No382 no382 = new No382(h);
        System.out.println(no382.getRandom());
    }
}
