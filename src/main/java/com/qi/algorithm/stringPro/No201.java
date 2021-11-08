package com.qi.algorithm.stringPro;

/**
 * Description: Bitwise AND of Numbers Range 数字范围按位与
 *
 * 思路：本题实际上就是求 left 和 right 的公共前缀
 *      可以用循环与
 *      也可以用 Brian Kernighan 算法，就是 n = n & (n - 1) 抹去最末位的 1
 *
 * Author: Qi
 * Date: 11-08-2021
 */
public class No201 {

    public int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        while (left <= right){
            ans &= left;
            ans &= right;
            left++;
            right--;
            if (ans == 0)return 0;
        }
        return ans;
    }

    public int rangeBitwiseAnd1(int left, int right) {
        while (left < right){
            right = right & (right - 1);
        }
        return right;
    }

    public static void main(String[] args) {
        No201 no201 = new No201();
        System.out.println(no201.rangeBitwiseAnd1(5,7));
    }
}
