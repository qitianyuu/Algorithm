package com.qi.algorithm.stringPro;

import java.util.LinkedList;

/**
 * Description: Super Pow 超级次方
 *
 * 思路：分解法，https://leetcode-cn.com/problems/super-pow/solution/you-qian-ru-shen-kuai-su-mi-suan-fa-xiang-jie-by-l/
 *
 * Author: Qi
 * Date: 11-11-2021
 */
public class No372 {

    int base = 1337;
    public int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : b) {
            list.add(i);
        }
        return super1(a, list);
    }

    private int super1(int a, LinkedList<Integer> list) {
        if (list.size() == 0)return 1;
        int last = list.pollLast();
        int part1 = superpow1(a, last);
        int part2 = superpow1(super1(a, list), 10);
        return part1 * part2 % base;
    }

    private int superpow1(int a, int last) {
        if (last == 0)return 1;
        a %= base;
        int ans = 1, x = a;
        //?
        while(last > 0){
            if(last % 2 == 1){
                ans = ans * x % base;
            }
            x = x * x % base;
            last /= 2;
        }
        return ans % base;
    }

    public static void main(String[] args) {
        No372 no372 = new No372();
        System.out.println(no372.superPow(2, new int[]{3}));
    }
}
