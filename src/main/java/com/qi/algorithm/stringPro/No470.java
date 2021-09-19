package com.qi.algorithm.stringPro;

/**
 * Description: Implement Rand10() Using Rand7() 用 Rand7() 实现 Rand10()
 * Author: Qi
 * Date: 09-19-2021
 */
public class No470{

    public int rand10() {
        int first, second;
        // first 代表符号，取 0-5然后判断奇偶正好有两种可能
        while ((first = rand7()) > 6);
        // second 代表位数 取小于 5 有五种可能，这样 2 X 5 就是10中等可能。
        while ((second = rand7()) > 5);
        return (first & 1) == 1 ? second : 5 + second;
    }

    private int rand7() {
        return 0;
    }

    public static void main(String[] args) {

    }
}
