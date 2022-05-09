package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: DI String Match 增减字符串匹配
 * Author: Qi
 * Date: 2022/5/9
 */
public class No942 {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int l = 0, r = n;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I'){
                list.add(l);
                l++;
            }else {
                list.add(r);
                r--;
            }
        }
        list.add(l);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        No942 no942 = new No942();
        System.out.println(Arrays.toString(no942.diStringMatch("IDID")));
    }
}
