package com.qi.algorithm.stringPro;

/**
 * Description: Slowest Key 按键持续时间最长的键
 * Author: Qi
 * Date: 01-09-2022
 */
public class No1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        char ans = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            char key = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (time == maxTime && key > ans)) {
                ans = key;
                maxTime = time;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        No1629 no1629 = new No1629();
        System.out.println(no1629.slowestKey(new int[]{12,23,36,46,62}, "spuda"));
    }
}
