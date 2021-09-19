package com.qi.algorithm.stringPro;

/**
 * Description: Count and Say 外观数列
 *
 * 思路：递归的思想，先递归出 n-1， 然后在处理 n-1 的结果，循环双指针计算每个数字的个数。
 *
 * Author: Qi
 * Date: 09-10-2021
 */
public class No38 {

    public String countAndSay(int n) {
        if (n == 1)return "1";
        else {
            String str = countAndSay(n - 1);
            StringBuffer sb = new StringBuffer();
            //3.     21
            //4.     1211
            //5.     111221

            int cur = 0, next = 1;
            while (next < str.length()){
                while (str.charAt(next) == str.charAt(cur)){
                    next++;
                    if (next == str.length()){
                        sb.append(next-cur).append(str.charAt(cur));
                        return sb.toString();
                    }
                }
                sb.append(next-cur).append(str.charAt(cur));
                cur = next;
                next++;
            }
            sb.append(next-cur).append(str.charAt(cur));
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        No38 no38 = new No38();
        String s = no38.countAndSay(5);
        System.out.println(s);
    }

}
