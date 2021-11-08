package com.qi.algorithm.stringPro;

/**
 * Description: Bulls and Cows 猜数字游戏
 *
 * 思路：一次遍历找到公牛，在次遍历统计出现个数，循环统计奶牛
 *
 * Author: Qi
 * Date: 11-08-2021
 */
public class No299 {

    public String getHint(String secret, String guess) {
        int a,b;
        a = b = 0;
        int[]visited = new int[secret.length()];
        int []sec = new int[10];
        int []gue = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                a++;
                visited[i] = 1;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (visited[i] != 1){
                sec[secret.charAt(i) - '0']++;
                gue[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(sec[i], gue[i]);
        }
        return String.valueOf(a)+"A"+ String.valueOf(b)+"B";
    }

    public static void main(String[] args) {
        No299 no299 = new No299();
        System.out.println(no299.getHint("1807", "7810"));
    }
}
