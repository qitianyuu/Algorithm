package com.qi.algorithm.stringPro;

/**
 * Description: Magical String 神奇字符串
 *
 * 思路：通过构造字符串不断遍历。
 *
 * Author: Qi
 * Date: 09-19-2021
 */
public class No481 {

    public int magicalString(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        int index = 1;
        while (sb.length() < n){
            if (index == sb.length()){
                sb.append(sb.charAt(sb.length()-1) == '1' ? "22" : "1");
                index++;
            }else {
                if (sb.charAt(sb.length() - 1) == '1'){
                    sb.append(sb.charAt(index) == '1' ? "2" : "22");
                    index++;
                }else {
                    sb.append(sb.charAt(index) == '1' ? "1" : "11");
                    index++;
                }
            }
        }
        // 统计 1 的个数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') ans++;
        }
        System.out.println(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        //122112122122112112
        No481 no481 = new No481();
        int i = no481.magicalString(20);
        System.out.println(i);
    }
}
