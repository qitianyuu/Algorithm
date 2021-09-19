package com.qi.algorithm.stringPro;

/**
 * Description: 67. 二进制求和 Add Binary
 *
 * 思路：先求出较长的那个，并将其长度作为循环条件
 *      然后将两者的末位开始循环加入临时变量，并考虑进位
 *      最后将stringbuffer进行反转输出
 *
 * Author: Qi
 * Date: 08-24-2021
 */
public class No67 {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0){
            return b;
        }
        if (b == null || b.length() == 0){
            return a;
        }

        int maxlen = Math.max(a.length(), b.length());
        StringBuffer sb = new StringBuffer();
        int tmp = 0;
        for (int i = 0; i < maxlen; i++) {
            tmp += i > a.length()-1 ? 0 : a.charAt(a.length() - i - 1) == '1'? 1 : 0;
            tmp += i > b.length()-1 ? 0 : b.charAt(b.length() - i - 1) == '1'? 1 : 0;
            sb.append((char)(tmp % 2 + '0'));
            tmp /= 2;
        }
        if (tmp != 0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No67 no67 = new No67();
        String s = no67.addBinary("1011", "101");
        System.out.println(s);
    }
}
