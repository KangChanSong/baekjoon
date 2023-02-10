package com.silver5;

import java.util.Scanner;

public class P1010_best {
    public static void main(String[] n){
        Scanner s=new Scanner(System.in);
        int p=s.nextInt(); // 1
        while(p-- > 0){
            int a=s.nextInt()+1; // 5 -> 6
            int b=s.nextInt(); // 8
            int k = 1, r = 1;

            while(a<=b) {
                k=k*a++/r++;
            }

            System.out.println(k);
        }
    }
}
