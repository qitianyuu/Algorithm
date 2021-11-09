package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: H-Index H 指数
 *
 * 思路：排序遍历，找到 min(index, num[index]) 中的最大值
 *
 * Author: Qi
 * Date: 11-09-2021
 */
public class No274 {

    public int hIndex(int[] citations) {
        int ans = Integer.MIN_VALUE;
        Integer[] tmp = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            tmp[i] = citations[i];
        }
        Arrays.sort(tmp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(tmp));
        for (int i = 0; i < tmp.length; i++) {
            ans = Math.max(Math.min(i+1, tmp[i]), ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        No274 no274 = new No274();
        System.out.println(no274.hIndex(new int[]{3,0,6,1,5}));
    }
}
