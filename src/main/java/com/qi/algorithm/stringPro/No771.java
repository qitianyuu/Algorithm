package com.qi.algorithm.stringPro;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Jewels and Stones 宝石与石头
 * Author: Qi
 * Date: 10-27-2021
 */
public class No771 {

    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set<Character> jewelsSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelsSet.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (jewelsSet.contains(stones.charAt(i)))ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        No771 no771 = new No771();
        System.out.println(no771.numJewelsInStones("aA", "aAAbbbb"));
    }
}
