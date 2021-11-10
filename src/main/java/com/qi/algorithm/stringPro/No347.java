package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: Top K Frequent Elements 前 K 个高频元素
 *
 * 思路：建立 hash 表，记录出现次数，然后排序，得到前k个。
 *
 * Author: Qi
 * Date: 11-10-2021
 */
public class No347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int[][]count = new int[map.size()][2];
        int tmp = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            count[tmp][0] = e.getKey();
            count[tmp][1] = e.getValue();
            tmp++;
        }
        Arrays.sort(count, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            if (count[i][1] != 0){
                ans[i] = count[i][0];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No347 no347 = new No347();
        int[] ints = no347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
