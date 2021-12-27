package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Friends Of Appropriate Ages 适龄的朋友
 *
 * 思路：先排序，然后再逐个遍历，针对每个 age，逐一判断左右边界，在中间的就是答案个数。
 *
 * Author: Qi
 * Date: 12-27-2021
 */
public class No825 {

    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15){
                continue;
            }
            while (ages[left] <= 0.5 * age + 7){
                left++;
            }
            while (right + 1 < n && ages[right + 1] <= age){
                right++;
            }
            ans += right - left;
        }
        return ans;
    }

    public static void main(String[] args) {
        No825 no825 = new No825();
        System.out.println(no825.numFriendRequests(new int[]{25, 25}));
    }
}
