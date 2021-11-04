package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Next Greater Numerically Balanced Number 下一个更大的数值平衡数
 *
 * 思路：从当前开始循环遍历，并且判断每一个数是不是平衡数
 *      判断方法为：hash 表记录每个数出现的次数和值，最后判断是否相等
 *
 * Author: Qi
 * Date: 11-04-2021
 */
public class No2048 {

    public int nextBeautifulNumber(int n) {
        int i = n+1;
        for (; i < Integer.MAX_VALUE; i++) {
            if(isBalance(i)) break;
        }
        return i;
    }

    private boolean isBalance(int i) {
        Map<Integer, Integer> map = new HashMap<>();
        while (i != 0){
            if (i % 10 > 7 || i % 10 == 0) return false;
            map.put(i % 10, map.getOrDefault(i % 10, 0)+1);
            i = i / 10;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != entry.getKey())return false;
        }
        return true;
    }

    public static void main(String[] args) {
        No2048 no2048 = new No2048();
        System.out.println(no2048.nextBeautifulNumber(23));
    }
}
