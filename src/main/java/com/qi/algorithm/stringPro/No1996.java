package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: The Number of Weak Characters in the Game 游戏中弱角色的数量
 *
 * 思路：单调栈，固定第一个元素的大小关系，用第二个元素的大小关系进行入栈操作
 *      同时重写排序方法。
 *
 * Author: Qi
 * Date: 01-28-2022
 */
public class No1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]);
            }
        });
        int ans = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int[] item: properties) {
            while (!dq.isEmpty() && dq.peek() < item[1]){
                dq.pop();
                ans++;
            }
            dq.push(item[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        No1996 no1996 = new No1996();
        System.out.println(no1996.numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
    }
}
