package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Find the Minimum Number of Fibonacci Numbers Whose Sum Is K 和为 K 的最少斐波那契数字数目
 *
 * 思路：先枚举所有小于 k 的斐波那且数，然后在采用贪心算法从大到小减
 *
 * Author: Qi
 * Date: 02-03-2022
 */
public class No1414 {

    public int findMinFibonacciNumbers(int k) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int a = 1, b = 1;
        while (a + b <= k){
            int c = a + b;
            list.add(c);
            a = b;
            b = c;
        }
        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
            if (k >= list.get(i)) {
                k -= list.get(i);
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No1414 no1414 = new No1414();
        System.out.println(no1414.findMinFibonacciNumbers(7));
    }
}
