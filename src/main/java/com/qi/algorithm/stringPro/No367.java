package com.qi.algorithm.stringPro;

/**
 * Description: Valid Perfect Square 有效的完全平方数
 *
 * 思路：二分查找，直到找到在 0 到 num 之间的那个数使得他的平方等于 num
 *
 * Author: Qi
 * Date: 11-04-2021
 */
public class No367 {

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            long sq = (long)mid * mid;
            if (sq == num){
                return true;
            }else if(sq < num){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No367 no367 = new No367();
        System.out.println(no367.isPerfectSquare(17));
    }
}
