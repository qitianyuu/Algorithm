package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Random Flip Matrix 随机翻转矩阵
 *
 * 思路：不能构建真实的数组，而是构建 m*n 的矩阵的索引。
 *
 * Author: Qi
 * Date: 11-27-2021
 */
public class No519 {
    class Solution {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        int m, n;
        public Solution(int m_, int n_) {
            m = m_;
            n = n_;
        }

        public int[] flip() {
            int a = random.nextInt(m * n);
            int b = a;
            while (a >= 0 && set.contains(a))a--;
            while (b < m * n && set.contains(b))b++;
            int c = a >=0 && !set.contains(a) ? a:b;
            set.add(c);
            return new int[]{c/n, c%n};
        }

        public void reset() {
            set.clear();
        }
    }
}
