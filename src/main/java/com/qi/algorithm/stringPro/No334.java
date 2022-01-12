package com.qi.algorithm.stringPro;

/**
 * Description: Increasing Triplet Subsequence 递增的三元子序列
 * Author: Qi
 * Date: 01-12-2022
 */
public class No334 {

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min){
                min = num;
            }else if (num <= mid){
                mid = num;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No334 no334 = new No334();
        System.out.println(no334.increasingTriplet(new int[]{2,1,5,0,4, 1 ,6}));
    }
}
