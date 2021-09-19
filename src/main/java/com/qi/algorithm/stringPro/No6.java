package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: ZigZag Conversion Z 字形变换
 *
 * 思路：从前往后迭代字符串，然后先创建好所有行，然后逐一确定每个字符的行位置，行数位0或者末尾时候要转换方向，设置方向变量
 *
 * Author: Qi
 * Date: 09-08-2021
 */
public class No6 {

    public String convert(String s, int numRows) {
        if (numRows == 1)return s;
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            StringBuffer sb = new StringBuffer();
            list.add(sb);
        }

        boolean direct = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(row).append(s.charAt(i));
            if (row == 0 || row == numRows - 1) direct = !direct;
            row += direct ? 1 : -1;
        }
        StringBuffer ans = new StringBuffer();
        list.forEach(item -> {
            ans.append(item);
        });
        return ans.toString();
    }

    public static void main(String[] args) {
        No6 no6 = new No6();
        String s = no6.convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
