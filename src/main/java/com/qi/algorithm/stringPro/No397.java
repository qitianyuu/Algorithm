package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Integer Replacement 整数替换
 *
 * 思路：迭代加记忆化搜索，通过 hash 表记录计算过的值。
 *
 * Author: Qi
 * Date: 11-19-2021
 */
public class No397 {

    Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        if (n == 1)return 0;
        if (!map.containsKey(n)){
            if (n % 2 == 0){
                map.put(n, 1 + integerReplacement( n / 2));
            }else {
                map.put(n, 1 + Math.min(integerReplacement(n+1),integerReplacement(n-1)));
            }
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        No397 no397 = new No397();
        System.out.println(no397.integerReplacement(20));
    }
}
