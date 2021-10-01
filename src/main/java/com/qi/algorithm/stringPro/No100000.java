package com.qi.algorithm.stringPro;

/**
 * Description:
 * Author: Qi
 * Date: 09-28-2021
 */


public class No100000 {

    public double process(int m, int n){
        double ans = 0, cur = m;
        for (int i = 0; i < n; i++) {
            ans += cur;
            cur = Math.sqrt(cur);
        }
        return (double) Math.round(ans * 100) / 100;
    }

    public static void main(String[] args) {
        No100000 no100000 = new No100000();
        double process = no100000.process(81, 4);
        System.out.println(process);
        //Scanner sc = new Scanner(System.in);
        //while(sc.hasNextInt()){
        //    String[] s = sc.nextLine().split(" ");
        //    for(int j = 0; j < s.length; j++){
        //        System.out.print(" "+s[j]);
        //    }
        //}

        //double d1 = 114.145;
        //d1 = (double) Math.round(d1 * 100) / 100;
        //System.out.println(d1);
        //
        //double d = 114.145;
        //String.format("%.2f", d);
    }
}
