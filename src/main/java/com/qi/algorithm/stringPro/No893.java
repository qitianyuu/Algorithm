package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Groups of Special-Equivalent Strings 特殊等价字符串组
 *
 * 思路：本题考虑计数问题，可以用 hash 表和数组，由于是26个字母，因此用 int 数组
 *      考虑奇偶问题，用 52 个元素的数组对其进行统计，奇偶各占前后26个
 *      最后转成 String 在 Set 进行统计。
 *
 * Author: Qi
 * Date: 11-06-2021
 */
public class No893 {

    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            int[]tmp = new int[52];
            for (int i = 0; i < word.length(); i++) {
                tmp[word.charAt(i) - 'a' + 26 * (i%2)]++;
            }
            set.add(Arrays.toString(tmp));
        }
        return set.size();
    }

    public static void main(String[] args) {
        No893 no893 = new No893();
        System.out.println(no893.numSpecialEquivGroups(new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
    }
}
