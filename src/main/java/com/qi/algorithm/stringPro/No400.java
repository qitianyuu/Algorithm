package com.qi.algorithm.stringPro;

/**
 * Description: Nth Digit 第 N 位数字
 *
 * 思路：首先找到规律，n 位数字的位数总共有 n * 9 * pow(10,n-1) 位，例如 2 位数有 2 * 9 * 10 = 180 位
 *      因此先确定这个数是几位数，再确定是哪个数，再确定是这个数的第几位。
 *
 * Author: Qi
 * Date: 11-30-2021
 */
public class No400 {

    public int findNthDigit(int n) {
        int low = 1, high = 9;
        while (low < high){
            int mid = (low + high) / 2;
            if (totalDig(mid) < n){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        int d = low;
        int prevDig = totalDig(d - 1);
        int idx = n - prevDig - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + idx / d;
        int digitIdx = idx % d;
        int digit = (num / ((int) Math.pow(10, d - digitIdx - 1))) % 10;
        return digit;
    }

    private int totalDig(int n) {
        int total = 0;
        int a = 1, b = 9;
        while (a <= n){
            total += a * b;
            b *= 10;
            a++;
        }
        return total;
    }

    public static void main(String[] args) {
        No400 no400 = new No400();
        System.out.println(no400.findNthDigit(11));
    }
}
